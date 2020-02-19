package com.andrewthesailor.cinemaTickets.DAO.impl;

import com.andrewthesailor.cinemaTickets.DAO.SeatDAO;
import com.andrewthesailor.cinemaTickets.model.Screening;
import com.andrewthesailor.cinemaTickets.model.Seat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SeatDAOImpl implements SeatDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Seat> getFreeSeats(Screening screening) {
        String query = "SELECT data FROM Seat data where data.room = :room and data not in " +
                "(SELECT data1 FROM Seat data1 join Ticket t on t.seat = data1 where t.reservation.screening = :screening)";
        TypedQuery<Seat> typedQuery = entityManager.createQuery(query, Seat.class).setParameter("room", screening.getRoom()).setParameter("screening",screening);
        return typedQuery.getResultList();
    }

    @Override
    public List<Seat> getReservedSeats(Screening screening) {
        String query = "SELECT data FROM Seat data join Ticket t on t.seat = data where t.reservation.screening = :screening";
        TypedQuery<Seat> typedQuery = entityManager.createQuery(query, Seat.class).setParameter("screening",screening);
        return typedQuery.getResultList();
    }

    @Override
    public Seat get(Long seatId) {
        String query = "SELECT data FROM Seat data where data.id =:id";
        TypedQuery<Seat> typedQuery = entityManager.createQuery(query, Seat.class).setParameter("id", seatId);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<Seat> getSeats(List<Long> ids) {
        String query = "SELECT data FROM Seat data where data.id in (:ids)";
        TypedQuery<Seat> typedQuery = entityManager.createQuery(query, Seat.class).setParameter("ids", ids);
        return typedQuery.getResultList();
    }
}

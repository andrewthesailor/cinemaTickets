package com.andrewthesailor.cinemaTickets.DAO.impl;

import com.andrewthesailor.cinemaTickets.DAO.ReservationDAO;
import com.andrewthesailor.cinemaTickets.model.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Reservation persist(Reservation reservation) {
        entityManager.persist(reservation);
        return reservation;
    }
}

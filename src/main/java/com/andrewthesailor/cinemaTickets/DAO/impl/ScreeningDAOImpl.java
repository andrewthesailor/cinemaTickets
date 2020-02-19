package com.andrewthesailor.cinemaTickets.DAO.impl;

import com.andrewthesailor.cinemaTickets.DAO.ScreeningDAO;
import com.andrewthesailor.cinemaTickets.model.Screening;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class ScreeningDAOImpl implements ScreeningDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Screening> getScreenings(Date startDate, Date endDate) {
        String query = "SELECT data FROM Screening data WHERE data.startDate>:startDate and data.startDate> :endDate";
        TypedQuery<Screening> resultQuery = entityManager.createQuery(query, Screening.class).setParameter("startDate", startDate).setParameter("endDate",endDate);
        return resultQuery.getResultList();
    }

    @Override
    public Screening getScreening(Long id) throws NoResultException {
        String query = "SELECT data FROM Screening data WHERE data.id = :id";
        TypedQuery<Screening> resultQuery = entityManager.createQuery(query, Screening.class).setParameter("id", id);
        return resultQuery.getSingleResult();
    }
}


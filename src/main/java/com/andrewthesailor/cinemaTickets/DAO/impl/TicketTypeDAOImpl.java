package com.andrewthesailor.cinemaTickets.DAO.impl;

import com.andrewthesailor.cinemaTickets.DAO.TicketTypeDAO;
import com.andrewthesailor.cinemaTickets.model.TicketType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TicketTypeDAOImpl implements TicketTypeDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public TicketType getByCode(String code) throws NoResultException {
        String query = "Select data from TicketType data where data.code=:code";
        TypedQuery<TicketType> typedQuery = entityManager.createQuery(query,TicketType.class).setParameter("code",code);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<String> getCodes() {
        String query = "Select distinct data.code from TicketType data";
        TypedQuery<String> typedQuery = entityManager.createQuery(query,String.class);
        return typedQuery.getResultList();
    }
}

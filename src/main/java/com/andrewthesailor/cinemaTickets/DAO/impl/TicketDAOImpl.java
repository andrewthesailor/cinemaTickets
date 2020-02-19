package com.andrewthesailor.cinemaTickets.DAO.impl;

import com.andrewthesailor.cinemaTickets.DAO.TicketDAO;
import com.andrewthesailor.cinemaTickets.model.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TicketDAOImpl implements TicketDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Ticket persist(Ticket ticket) {
        entityManager.persist(ticket);
        return ticket;
    }
}

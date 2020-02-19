package com.andrewthesailor.cinemaTickets.service.impl;

import com.andrewthesailor.cinemaTickets.DAO.TicketDAO;
import com.andrewthesailor.cinemaTickets.model.Ticket;
import com.andrewthesailor.cinemaTickets.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    final
    TicketDAO ticketDAO;

    public TicketServiceImpl(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }


    @Override
    public Ticket persist(Ticket ticket) {
        ticketDAO.persist(ticket);
        return ticket;
    }
}

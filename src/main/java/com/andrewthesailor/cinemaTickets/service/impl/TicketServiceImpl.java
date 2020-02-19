package com.andrewthesailor.cinemaTickets.service.impl;

import com.andrewthesailor.cinemaTickets.DAO.TicketDAO;
import com.andrewthesailor.cinemaTickets.model.Ticket;
import com.andrewthesailor.cinemaTickets.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    final
    TicketDAO ticketDAO;

    @Override
    public Ticket persist(Ticket ticket) {
        ticketDAO.persist(ticket);
        return ticket;
    }
}

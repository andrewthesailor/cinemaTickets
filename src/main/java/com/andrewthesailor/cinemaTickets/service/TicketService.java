package com.andrewthesailor.cinemaTickets.service;

import com.andrewthesailor.cinemaTickets.model.Ticket;

public interface TicketService {
    Ticket persist(Ticket ticket);

}

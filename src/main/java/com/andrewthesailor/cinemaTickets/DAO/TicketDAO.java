package com.andrewthesailor.cinemaTickets.DAO;

import com.andrewthesailor.cinemaTickets.model.Ticket;

public interface TicketDAO {

    Ticket persist(Ticket ticket);
}

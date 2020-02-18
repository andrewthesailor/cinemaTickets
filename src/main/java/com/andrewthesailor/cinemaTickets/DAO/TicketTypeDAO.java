package com.andrewthesailor.cinemaTickets.DAO;

import com.andrewthesailor.cinemaTickets.model.TicketType;

public interface TicketTypeDAO {
    public TicketType getByCode(String code);
}

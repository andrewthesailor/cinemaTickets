package com.andrewthesailor.cinemaTickets.DAO;

import com.andrewthesailor.cinemaTickets.model.TicketType;

import java.util.List;

public interface TicketTypeDAO {
    public TicketType getByCode(String code);
    public List<String> getCodes();
}

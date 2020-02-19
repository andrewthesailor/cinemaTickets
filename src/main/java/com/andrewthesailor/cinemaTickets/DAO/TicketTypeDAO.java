package com.andrewthesailor.cinemaTickets.DAO;

import com.andrewthesailor.cinemaTickets.model.TicketType;

import java.util.List;

public interface TicketTypeDAO {
    TicketType getByCode(String code);

    List<String> getCodes();
}

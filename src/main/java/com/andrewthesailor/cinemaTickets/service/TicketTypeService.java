package com.andrewthesailor.cinemaTickets.service;

import com.andrewthesailor.cinemaTickets.model.TicketType;

import java.util.List;

public interface TicketTypeService {
    TicketType getByCode(String code);

    void verifyCodes(List<String> ticketTypeCodes);
}

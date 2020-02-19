package com.andrewthesailor.cinemaTickets.service.impl;

import com.andrewthesailor.cinemaTickets.DAO.TicketTypeDAO;
import com.andrewthesailor.cinemaTickets.exception.TicketException;
import com.andrewthesailor.cinemaTickets.model.TicketType;
import com.andrewthesailor.cinemaTickets.service.TicketTypeService;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {

    final
    TicketTypeDAO ticketTypeDAO;

    public TicketTypeServiceImpl(TicketTypeDAO ticketTypeDAO) {
        this.ticketTypeDAO = ticketTypeDAO;
    }

    @Override
    public TicketType getByCode(String code) throws NoResultException {
        return ticketTypeDAO.getByCode(code);
    }


    @Override
    public void verifyCodes(List<String> ticketTypeCodes) {
        List<String> codes = ticketTypeDAO.getCodes();
        List<String> invalidCodes = new ArrayList<>();
        for (String ticketType : ticketTypeCodes) {
            if (!codes.contains(ticketType)) {
                invalidCodes.add(ticketType);
            }
        }
        if (!invalidCodes.isEmpty()) {
            throw new TicketException("Invalid ticket types: " + invalidCodes);
        }
    }
}

package com.andrewthesailor.cinemaTickets.service.impl;

import com.andrewthesailor.cinemaTickets.DAO.ScreeningDAO;
import com.andrewthesailor.cinemaTickets.exception.TicketException;
import com.andrewthesailor.cinemaTickets.model.Screening;
import com.andrewthesailor.cinemaTickets.service.ScreeningService;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    final
    ScreeningDAO dao;

    public ScreeningServiceImpl(ScreeningDAO dao) {
        this.dao = dao;
    }


    @Override
    public List<Screening> getScreenings(Date startDate, Date endDate) {
        return dao.getScreenings(startDate, endDate);
    }

    @Override
    public Screening getScreening(Long screeningId) throws NoResultException {
        try {
            return dao.getScreening(screeningId);
        }catch(NoResultException ex){
            throw new TicketException("No screening with id"+screeningId+" found");
        }
    }

}

package com.andrewthesailor.cinemaTickets.service.impl;

import com.andrewthesailor.cinemaTickets.DAO.ScreeningDAO;
import com.andrewthesailor.cinemaTickets.model.Screening;
import com.andrewthesailor.cinemaTickets.model.Seat;
import com.andrewthesailor.cinemaTickets.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    @Autowired
    ScreeningDAO dao;

    @Override
    public List<Screening> getScreenings(Date startDate, Date endDate) {
        return dao.getScreenings(startDate, endDate);
    }

    @Override
    public Screening getScreening(Long screeningId) {
        return dao.getScreening(screeningId);
    }

    @Override
    public List<Seat> getFreeSeats(Long screeningId) {
        return null;
    }
}

package com.andrewthesailor.cinemaTickets.service.impl;

import com.andrewthesailor.cinemaTickets.DAO.SeatDAO;
import com.andrewthesailor.cinemaTickets.model.Screening;
import com.andrewthesailor.cinemaTickets.model.Seat;
import com.andrewthesailor.cinemaTickets.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    final
    SeatDAO seatDAO;

    public SeatServiceImpl(SeatDAO seatDAO) {
        this.seatDAO = seatDAO;
    }

    @Override
    public List<Seat> getFreeSeats(Screening screening) {
        return seatDAO.getFreeSeats(screening);
    }

    @Override
    public Seat getSeat(Long seatId) {
        return seatDAO.get(seatId);
    }

    @Override
    public List<Seat> getSeats(List<Long> ids) {
        return seatDAO.getSeats(ids);
    }

    @Override
    public List<Seat> getReservedSeats(Screening screening) {
        return seatDAO.getReservedSeats(screening);
    }
}

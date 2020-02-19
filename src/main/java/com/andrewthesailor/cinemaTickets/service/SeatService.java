package com.andrewthesailor.cinemaTickets.service;

import com.andrewthesailor.cinemaTickets.model.Screening;
import com.andrewthesailor.cinemaTickets.model.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getFreeSeats(Screening screening);

    Seat getSeat(Long seatId);

    List<Seat> getSeats(List<Long> ids);

    List<Seat>getReservedSeats(Screening screening);
}

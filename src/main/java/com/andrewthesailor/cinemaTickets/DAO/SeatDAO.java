package com.andrewthesailor.cinemaTickets.DAO;

import com.andrewthesailor.cinemaTickets.model.Screening;
import com.andrewthesailor.cinemaTickets.model.Seat;

import java.util.List;

public interface SeatDAO {
    List<Seat> getFreeSeats(Screening screening);

    Seat get(Long seatId);

    List<Seat> getSeats(List<Long> ids);

    List<Seat> getReservedSeats(Screening screening);
}

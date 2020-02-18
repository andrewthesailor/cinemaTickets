package com.andrewthesailor.cinemaTickets.service;

import com.andrewthesailor.cinemaTickets.model.Screening;
import com.andrewthesailor.cinemaTickets.model.Seat;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public interface ScreeningService {

    List<Screening> getScreenings(Date startDate, Date endDate);

    Screening getScreening(Long screeningId);

    List<Seat> getFreeSeats(Long screeningId);
}

package com.andrewthesailor.cinemaTickets.service;

import com.andrewthesailor.cinemaTickets.model.Screening;

import java.util.Date;
import java.util.List;

public interface ScreeningService {

    List<Screening> getScreenings(Date startDate, Date endDate);

    Screening getScreening(Long screeningId);

}

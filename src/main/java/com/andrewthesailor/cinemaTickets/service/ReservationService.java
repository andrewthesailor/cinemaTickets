package com.andrewthesailor.cinemaTickets.service;

import com.andrewthesailor.cinemaTickets.model.Jsons.ReservationDetails;
import com.andrewthesailor.cinemaTickets.model.Jsons.ReservationRequestData;

public interface ReservationService {
    ReservationDetails processReservation(ReservationRequestData data, Long screeningId);

}

package com.andrewthesailor.cinemaTickets.DAO;

import com.andrewthesailor.cinemaTickets.model.Reservation;

public interface ReservationDAO {
    Reservation persist(Reservation reservation);
}

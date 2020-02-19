package com.andrewthesailor.cinemaTickets.model.Jsons;

import com.andrewthesailor.cinemaTickets.model.Seat;
import lombok.Data;

import java.util.List;

@Data
public class ScreeningDetails {
    private String roomNumber;
    private List<Seat> seatList;
}

package com.andrewthesailor.cinemaTickets.model.Jsons;

import lombok.Data;

@Data
public class ScreeningDetails {
    private String roomNumber;
    private SeatList seatList;


}

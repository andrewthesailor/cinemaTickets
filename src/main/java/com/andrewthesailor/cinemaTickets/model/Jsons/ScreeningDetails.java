package com.andrewthesailor.cinemaTickets.model.Jsons;

import lombok.Data;

import java.util.List;

@Data
public class ScreeningDetails {
    private String roomNumber;
    private List seatList;


}

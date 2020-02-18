package com.andrewthesailor.cinemaTickets.model.Jsons;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationDetails {
    private Date expirationDate;
    private Double amountToPay;
}

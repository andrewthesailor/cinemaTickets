package com.andrewthesailor.cinemaTickets.model.Jsons;

import lombok.Data;

@Data
public class ReservationRequestData {
private String name;
private String surname;
private TicketList ticketList;
}

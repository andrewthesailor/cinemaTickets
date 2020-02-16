package com.andrewthesailor.cinemaTickets.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "T_TICKET_TYPES")
@SequenceGenerator(name = "S_TICKET_TYPE_ID", sequenceName = "S_TICKET_TYPE_ID", allocationSize = 50)
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_TICKET_TYPE_ID")
    @Column(name = "TICKET_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TICKET_RESERVATION_ID")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "TICKET_SCREENING_ID")
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "TICKET_SEAT_ID")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "TICKET_TICKET_TYPE_ID")
    private TicketType ticketType;
}

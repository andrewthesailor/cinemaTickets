package com.andrewthesailor.cinemaTickets.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "T_RESERVATIONS")
@SequenceGenerator(name = "S_RESERVATION_ID", sequenceName = "S_RESERVATION_ID", allocationSize = 50)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_SEAT_ID")
    @Column(name = "RESERVATION_ID")
    private Long id;

    @Column(name = "RESERVATION_NAME")
    private String name;

    @Column(name = "RESERVATION_SURNAME")
    private String surname;

    @Column(name = "RESERVATION_CREATION_DATE")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_SCREENING_ID")
    private Screening screening;
}

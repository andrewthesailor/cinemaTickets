package com.andrewthesailor.cinemaTickets.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "T_SEATS")
@SequenceGenerator(name = "S_SEAT_ID", sequenceName = "S_SEAT_ID", allocationSize = 50)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_SEAT_ID")
    @Column(name = "SEAT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SEAT_ROOM_ID")
    private Room room;

    @Column(name = "SEAT_COLUMN_NUMBER")
    private Integer column;

    @Column(name = "SEAT_ROW_NUMBER")
    private Integer row;

}

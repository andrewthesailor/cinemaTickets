package com.andrewthesailor.cinemaTickets.model;


import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "T_ROOMS")
@SequenceGenerator(name = "S_ROOM_ID", sequenceName = "S_ROOM_ID", allocationSize = 50)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ROOM_ID")
    @Column(name = "ROOM_ID")
    @JsonIgnore
    private Long id;

    @Column(name = "ROOM_NUMBER")
    private String name;
}

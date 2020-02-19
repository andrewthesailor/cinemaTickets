package com.andrewthesailor.cinemaTickets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "T_SCREENINGS")
@SequenceGenerator(name = "S_SCREENING_ID", sequenceName = "S_SCREENING_ID", allocationSize = 50)
@JsonIgnoreProperties({"room","reservations"})
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_SCREENING_ID")
    @Column(name = "SCREENING_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SCREENING_ROOM_ID")
    private Room room;

    @Column(name = "SCREENING_TITLE")
    private String title;

    @Column(name = "SCREENING_START_HOUR")
    private Date startDate;

}

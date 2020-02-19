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
    @Column(name = "TICKET_TYPE_ID")
    private Long id;

    @Column(name = "TICKET_TYPE_CODE")
    private String code;

    @Column(name = "TICKET_TYPE_NAME")
    private String name;

    @Column(name = "TICKET_TYPE_PRICE")
    private Double price;
}

package com.andrewthesailor.cinemaTickets.controller;

import com.andrewthesailor.cinemaTickets.model.Jsons.ReservationDetails;
import com.andrewthesailor.cinemaTickets.model.Jsons.ReservationRequestData;
import com.andrewthesailor.cinemaTickets.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    final
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(path = "/reserve/{screeningId}")
    public ResponseEntity<ReservationDetails>reserve(@PathVariable Long screeningId, @RequestBody @Valid ReservationRequestData data){

        return new ResponseEntity<ReservationDetails>(reservationService.processReservation(data,screeningId), HttpStatus.OK);
    }




}

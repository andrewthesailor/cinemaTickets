package com.andrewthesailor.cinemaTickets.controller;

import com.andrewthesailor.cinemaTickets.model.Jsons.ReservationDetails;
import com.andrewthesailor.cinemaTickets.model.Jsons.ReservationRequestData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @PostMapping(path = "/reserve/{screeningId}")
    public ResponseEntity<ReservationDetails>reserve(@PathVariable Long screeningId, @RequestBody @Valid ReservationRequestData data){



        return null;
    }




}

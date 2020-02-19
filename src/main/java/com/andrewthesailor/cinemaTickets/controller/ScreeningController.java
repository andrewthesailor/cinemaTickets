package com.andrewthesailor.cinemaTickets.controller;


import com.andrewthesailor.cinemaTickets.model.Jsons.ScreeningDetails;
import com.andrewthesailor.cinemaTickets.model.Jsons.ScreeningSearchData;
import com.andrewthesailor.cinemaTickets.model.Screening;
import com.andrewthesailor.cinemaTickets.service.ScreeningService;
import com.andrewthesailor.cinemaTickets.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/screening")
@AllArgsConstructor
public class ScreeningController {

    final
    ScreeningService screeningService;

    final
    SeatService seatService;

    @GetMapping(value = "/getScreenings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Screening>> getScreenings(@Valid @RequestBody ScreeningSearchData data) {
        return new ResponseEntity<List<Screening>>(screeningService.getScreenings(data.getStartDate(), data.getEndDate()), HttpStatus.OK);
    }

    @GetMapping(value = "/getDetails/{screeningId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ScreeningDetails> getScreeningDetails(@PathVariable(value = "screeningId", required = true) Long screeningId) {
        Screening screening = screeningService.getScreening(screeningId);
        ScreeningDetails details = new ScreeningDetails();
        details.setRoomNumber(screening.getRoom().getName());
        details.setSeatList(seatService.getFreeSeats(screening));
        return new ResponseEntity<ScreeningDetails>(details, HttpStatus.OK);
    }


}

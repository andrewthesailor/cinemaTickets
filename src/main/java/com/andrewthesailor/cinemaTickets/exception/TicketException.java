package com.andrewthesailor.cinemaTickets.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TicketException extends RuntimeException {
    private String error;

    public TicketException(String error) {
        this.error = error;
    }
}

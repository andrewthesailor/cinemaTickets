package com.andrewthesailor.cinemaTickets.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    @ExceptionHandler(TicketException.class)
    public ResponseEntity<String> handleIllegalArgument(TicketException ex) {
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
    }
}
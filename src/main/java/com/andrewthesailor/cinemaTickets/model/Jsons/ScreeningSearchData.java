package com.andrewthesailor.cinemaTickets.model.Jsons;

import lombok.Data;

import java.util.Date;

@Data
public class ScreeningSearchData {
    private Date startDate;
    private Date endDate;
}

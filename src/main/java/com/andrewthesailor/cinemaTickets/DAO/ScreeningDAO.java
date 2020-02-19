package com.andrewthesailor.cinemaTickets.DAO;

import com.andrewthesailor.cinemaTickets.model.Screening;

import java.util.Date;
import java.util.List;

public interface ScreeningDAO {

    public List<Screening> getScreenings(Date startDate, Date endDate);

    public Screening getScreening(Long id);
}

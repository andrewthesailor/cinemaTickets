package com.andrewthesailor.cinemaTickets.service.impl;

import com.andrewthesailor.cinemaTickets.DAO.ReservationDAO;
import com.andrewthesailor.cinemaTickets.exception.TicketException;
import com.andrewthesailor.cinemaTickets.model.Jsons.ReservationDetails;
import com.andrewthesailor.cinemaTickets.model.Jsons.ReservationRequestData;
import com.andrewthesailor.cinemaTickets.model.Jsons.TicketData;
import com.andrewthesailor.cinemaTickets.model.*;
import com.andrewthesailor.cinemaTickets.service.*;
import com.andrewthesailor.cinemaTickets.utils.StringUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    final
    ScreeningService screeningService;

    final
    SeatService seatService;

    final
    TicketTypeService ticketTypeService;

    final
    ReservationDAO reservationDAO;

    final
    TicketService ticketService;

    final
    StringUtil stringUtil;

    @Override
    @Transactional
    public ReservationDetails processReservation(ReservationRequestData data, Long screeningId) throws TicketException {
        Screening screening;
        try {
            screening = screeningService.getScreening(screeningId);
        } catch (NoResultException ex) {
            throw new TicketException("no screening found with id:" + screeningId);
        }
        verifyDate(screening);
        verifySeats(data, screening);
        ReservationDetails reservationDetails = new ReservationDetails();
        reservationDetails.setAmountToPay(storeReservation(data, screening));
        reservationDetails.setExpirationDate(new Date(screening.getStartDate().getTime() - 900000));
        return reservationDetails;
    }

    private void verifyDate(Screening screening) throws TicketException {
        if (screening.getStartDate().getTime() - (new Date()).getTime() < 900000) {
            throw new TicketException("Reservation not possible: reservations are closed");
        }
    }

    private void verifySeats(ReservationRequestData data, Screening screening) throws TicketException {
        List<Seat> freeSeats = seatService.getFreeSeats(screening);
        List<Long> ids = data.getTicketList().stream().flatMap(p -> Stream.of(p.getSeatId())).collect(Collectors.toList());
        List<String> ticketTypeCodes = data.getTicketList().stream().flatMap(p -> Stream.of(p.getTicketTypeCode())).collect(Collectors.toList());
        findDuplicates(ids);
        findWrongSeats(ids, freeSeats);
        verifySeatOrder(ids, screening);
        verifyNameAndSurname(data.getName(), data.getSurname());
        ticketTypeService.verifyCodes(ticketTypeCodes);
    }

    private void verifyNameAndSurname(String name, String surname) {
        if (!stringUtil.verifyName(name)) {
            throw new TicketException("Invalid name");
        }
        if (!stringUtil.verifySurname(surname)) {
            throw new TicketException("Invalid surname");
        }

    }

    private void verifySeatOrder(List<Long> ids, Screening screening) {
        List<Seat> seatsToReserve = seatService.getSeats(ids);
        List<Seat> reservedSeats = seatService.getReservedSeats(screening);
        List<Integer> rowsToVerify = seatsToReserve.stream().flatMap(p -> Stream.of(p.getRow())).distinct().collect(Collectors.toList());
        List<Integer> invalidRows = new ArrayList<>();
        for (Integer row : rowsToVerify) {
            List<Seat> seats = seatsToReserve.stream().filter(p -> p.getRow().equals(row)).collect(Collectors.toList());
            seats.addAll(reservedSeats.stream().filter(p -> p.getRow().equals(row)).collect(Collectors.toList()));
            seats.sort(Comparator.comparingInt(Seat::getColumn));
            Integer seatSize = seats.size() - 1;
            Integer reservedSeatCount = seats.get(seatSize).getColumn() - seats.get(0).getColumn();
            if (!seatSize.equals(reservedSeatCount)) {
                invalidRows.add(row);
            }
        }
        if (!invalidRows.isEmpty()) {
            throw new TicketException("Seats in rows: " + invalidRows + " are leaving empty spaces");
        }
    }

    private void findDuplicates(List<Long> ids) {
        List<Long> duplicates = ids.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        if (!duplicates.isEmpty())
            throw new TicketException("Duplicate seats with id:" + duplicates);
    }

    private void findWrongSeats(List<Long> ids, List<Seat> freeSeats) {
        List<Long> seatsIds = freeSeats.stream().flatMap(p -> Stream.of(p.getId())).collect(Collectors.toList());
        List<Long> wrongSeats = new ArrayList<>();
        for (Long id : ids) {
            if (!seatsIds.contains(id)) {
                wrongSeats.add(id);
            }
        }
        if (!wrongSeats.isEmpty())
            throw new TicketException("Seats with id:" + wrongSeats + " are unavailable");
    }

    private Double storeReservation(ReservationRequestData data, Screening screening) {
        Reservation reservation = new Reservation();
        reservation.setCreationDate(new Date());
        reservation.setName(data.getName());
        reservation.setSurname(data.getSurname());
        reservation.setScreening(screening);
        reservation = persistReservation(reservation);
        Double amountToPay = 0.00;
        for (TicketData ticketData : data.getTicketList()) {
            Ticket ticket = new Ticket();
            ticket.setReservation(reservation);
            Seat seat = seatService.getSeat(ticketData.getSeatId());
            ticket.setSeat(seat);
            TicketType ticketType = ticketTypeService.getByCode(ticketData.getTicketTypeCode());
            ticket.setTicketType(ticketType);
            amountToPay += ticketType.getPrice();
            persistTicket(ticket);
        }
        return amountToPay;
    }

    private void persistTicket(Ticket ticket) {
        ticketService.persist(ticket);
    }

    private Reservation persistReservation(Reservation reservation) {
        return reservationDAO.persist(reservation);
    }

}

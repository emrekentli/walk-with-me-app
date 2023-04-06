package com.doggo.app.domain.reservation.reservation.api;

import java.util.List;

public interface ReservationService {
    ReservationDto createReservation(ReservationDto dto);

    List<ReservationDto> getReservations();

    ReservationDto getReservation(String id);
}

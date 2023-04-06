package com.doggo.app.domain.reservation.reservation_request.api;

import java.util.List;

public interface ReservationRequestService {
    ReservationRequestDto createReservationRequest(ReservationRequestDto dto);

    List<ReservationRequestDto> getReservationRequests();

    ReservationRequestDto getReservationRequest(String id);

    ReservationRequestDto updateReservationRequest(String id, ReservationRequestDto toDto);

    List<ReservationRequestDto> getReservationRequestsByCustomer(String id);
}

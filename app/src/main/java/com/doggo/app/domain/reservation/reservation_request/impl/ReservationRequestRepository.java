package com.doggo.app.domain.reservation.reservation_request.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRequestRepository extends JpaRepository<ReservationRequest, String> {
}

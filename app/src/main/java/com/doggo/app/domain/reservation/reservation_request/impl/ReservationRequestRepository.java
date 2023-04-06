package com.doggo.app.domain.reservation.reservation_request.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRequestRepository extends JpaRepository<ReservationRequest, String> {
    boolean existsByAnimalIdAndCustomerIdAndStartDateAndEndDate(String animalId, String customerId, Date startDate, Date endDate);

    List<ReservationRequest> findAllByCustomerId(String id);
}

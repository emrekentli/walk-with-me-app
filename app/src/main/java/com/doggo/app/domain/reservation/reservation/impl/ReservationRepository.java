package com.doggo.app.domain.reservation.reservation.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findAllByWalkerIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual (String walkerId, Date startDate,Date endDate);
}

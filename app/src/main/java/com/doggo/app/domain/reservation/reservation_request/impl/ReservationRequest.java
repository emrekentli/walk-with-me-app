package com.doggo.app.domain.reservation.reservation_request.impl;

import com.doggo.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ReservationRequest.TABLE)
public class ReservationRequest extends AbstractEntity {
    public static final String TABLE = "reservation_req";
    public static final String COL_ANIMAL_ID = "animal_id";
    public static final String COL_CUSTOMER_ID = "customer_id";
    public static final String COL_RESERVATION_START_DATE = "start_date";
    public static final String COL_RESERVATION_END_DATE = "end_date";
    public static final String COL_STATUS = "status";

    @Column(name = COL_ANIMAL_ID, nullable = false)
    private String animalId;
    @Column(name = COL_CUSTOMER_ID, nullable = false)
    private String customerId;
    @Column(name = COL_RESERVATION_START_DATE, nullable = false)
    private Date startDate;
    @Column(name = COL_RESERVATION_END_DATE, nullable = false)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = COL_STATUS, nullable = false)
    private ReservationRequestStatus status;

}

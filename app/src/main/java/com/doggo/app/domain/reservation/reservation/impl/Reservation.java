package com.doggo.app.domain.reservation.reservation.impl;

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
@Table(name = Reservation.TABLE)
public class Reservation extends AbstractEntity {
    public static final String TABLE = "reservation";
    public static final String COL_ANIMAL_ID = "animal_id";
    public static final String COL_REQUEST_ID = "request_id";
    public static final String COL_WALKER_ID = "walker_id";
    public static final String COL_RESERVATION_START_DATE = "start_date";
    public static final String COL_RESERVATION_END_DATE = "end_date";
    public static final String COL_STATUS = "status";

    @Column(name = COL_ANIMAL_ID, nullable = false)
    private String animalId;
    @Column(name = COL_WALKER_ID, nullable = false)
    private String walkerId;
    @Column(name = COL_REQUEST_ID, nullable = false)
    private String requestId;
    @Column(name = COL_RESERVATION_START_DATE, nullable = false)
    private Date startDate;
    @Column(name = COL_RESERVATION_END_DATE, nullable = false)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = COL_STATUS, nullable = false)
    private ReservationStatus status;

}

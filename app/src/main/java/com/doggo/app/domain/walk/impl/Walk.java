package com.doggo.app.domain.walk.impl;

import com.doggo.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Walk.TABLE)
public class Walk extends AbstractEntity {
    public static final String TABLE = "walk";
    public static final String COL_RESERVATION_ID = "rez_id";
    public static final String COL_DISTANCE = "distance";
    public static final String COL_DURATION = "duration";
    public static final String COL_RESERVATION_START_DATE = "start_date";
    public static final String COL_RESERVATION_END_DATE = "end_date";

    @Column(name = COL_RESERVATION_ID, nullable = false)
    private String reservationId;
    @Column(name = COL_DISTANCE, nullable = false)
    private Double distance;
    @Column(name = COL_DURATION, nullable = false)
    private Double duration;
    @Column(name = COL_RESERVATION_START_DATE, nullable = false)
    private Date startDate;
    @Column(name = COL_RESERVATION_END_DATE, nullable = false)
    private Date endDate;
}

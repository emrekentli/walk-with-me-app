package com.doggo.app.domain.reservation.reservation.api;
import com.doggo.app.domain.reservation.reservation.impl.ReservationStatus;
import com.doggo.app.domain.reservation.reservation.web.ReservationResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class ReservationDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final ReservationStatus status;
    private final String animalId;
    private final String walkerId;
    private final String requestId;
    private final Date startDate;
    private final Date endDate;


    public static ReservationResponse toResponse(ReservationDto dto) {
        return ReservationResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .status(dto.getStatus())
                .animalId(dto.getAnimalId())
                .walkerId(dto.getWalkerId())
                .requestId(dto.getRequestId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
}

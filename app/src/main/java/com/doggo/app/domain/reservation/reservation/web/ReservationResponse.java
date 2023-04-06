package com.doggo.app.domain.reservation.reservation.web;

import com.doggo.app.domain.people.walker.api.WalkerDto;
import com.doggo.app.domain.reservation.reservation.api.ReservationDto;
import com.doggo.app.domain.reservation.reservation.impl.ReservationStatus;
import com.doggo.app.domain.reservation.reservation_request.api.ReservationRequestDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReservationResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final ReservationStatus status;
    private final WalkerDto walkerId;
    private final ReservationRequestDto request;
    private final Date startDate;
    private final Date endDate;

    public static ReservationResponse toResponse(ReservationDto dto) {
        return ReservationResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .status(dto.getStatus())
                .walkerId(dto.getWalkerDto())
                .request(dto.getRequestDto())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
}

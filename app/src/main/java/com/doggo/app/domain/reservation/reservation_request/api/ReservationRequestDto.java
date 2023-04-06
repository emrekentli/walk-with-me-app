package com.doggo.app.domain.reservation.reservation_request.api;
import com.doggo.app.domain.reservation.reservation_request.impl.ReservationRequestStatus;
import com.doggo.app.domain.reservation.reservation_request.web.ReservationRequestResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class ReservationRequestDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final ReservationRequestStatus status;
    private final String animalId;
    private final String customerId;
    private final Date startDate;
    private final Date endDate;


    public static ReservationRequestResponse toResponse(ReservationRequestDto dto) {
        return ReservationRequestResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .status(dto.getStatus())
                .animalId(dto.getAnimalId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
}

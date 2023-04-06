package com.doggo.app.domain.walk.api;

import com.doggo.app.domain.reservation.reservation.api.ReservationDto;
import com.doggo.app.domain.walk.web.WalkResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class WalkDto {

    private final String id;
    private final Date created;
    private final Date modified;
    private final Double duration;
    private final Double distance;
    private final ReservationDto reservationDto;
    private final Date startDate;
    private final Date endDate;
    public static WalkResponse toResponse(WalkDto dto) {
        return WalkResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .distance(dto.getDistance())
                .duration(dto.getDuration())
                .reservationDto(dto.getReservationDto())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
}

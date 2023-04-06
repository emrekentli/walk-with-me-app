package com.doggo.app.domain.walk.web;

import com.doggo.app.domain.reservation.reservation.api.ReservationDto;
import com.doggo.app.domain.walk.api.WalkDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class WalkRequest {
    @NotBlank
    private final String reservationId;
    @NotNull
    private final Double duration;
    @NotNull
    private final Double distance;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final Date startDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final  Date endDate;

    public WalkDto toDto() {
        return WalkDto.builder()
                .reservationDto(ReservationDto.builder().id(reservationId).build())
                .duration(duration)
                .distance(distance)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}

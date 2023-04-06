package com.doggo.app.domain.reservation.reservation_request.web;

import com.doggo.app.domain.reservation.reservation_request.api.ReservationRequestDto;
import com.doggo.app.domain.reservation.reservation_request.impl.ReservationRequestStatus;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class ReservationRequestRequest {
    @NotBlank
    private final String animalId;
    @NotBlank
    private final String customerId;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final Date startDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final Date endDate;
    @NotNull
    private final ReservationRequestStatus status;

    public ReservationRequestDto toDto() {
        return ReservationRequestDto.builder()
                .animalId(animalId)
                .customerId(customerId)
                .startDate(startDate)
                .endDate(endDate)
                .status(status)
                .build();
    }
}

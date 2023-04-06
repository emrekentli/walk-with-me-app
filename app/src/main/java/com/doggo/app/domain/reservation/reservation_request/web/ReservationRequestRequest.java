package com.doggo.app.domain.reservation.reservation_request.web;

import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.people.customer.api.CustomerDto;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final Date startDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final Date endDate;
    @NotNull
    private final ReservationRequestStatus status;

    public ReservationRequestDto toDto() {
        return ReservationRequestDto.builder()
                .animal(AnimalDto.builder().id(animalId).build())
                .customer(CustomerDto.builder().id(customerId).build())
                .startDate(startDate)
                .endDate(endDate)
                .status(status)
                .build();
    }
}

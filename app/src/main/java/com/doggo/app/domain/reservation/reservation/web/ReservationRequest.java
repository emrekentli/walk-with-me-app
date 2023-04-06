package com.doggo.app.domain.reservation.reservation.web;

import com.doggo.app.domain.reservation.reservation.api.ReservationDto;
import com.doggo.app.domain.reservation.reservation.impl.ReservationStatus;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class ReservationRequest {
    @NotBlank
    private final String animalId;
    @NotBlank
    private final String walkerId;
    @NotBlank
    private final String requestId;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final  Date startDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final  Date endDate;
    @NotNull
    private final ReservationStatus status;

 public ReservationDto toDto() {
  return ReservationDto.builder()
          .animalId(animalId)
            .walkerId(walkerId)
            .requestId(requestId)
            .startDate(startDate)
            .endDate(endDate)
          .status(status)
          .build();
 }
}

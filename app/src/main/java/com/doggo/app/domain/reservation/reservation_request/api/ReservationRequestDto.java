package com.doggo.app.domain.reservation.reservation_request.api;
import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.people.customer.api.CustomerDto;
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
    private final AnimalDto animal;
    private final CustomerDto customer;
    private final Date startDate;
    private final Date endDate;


    public static ReservationRequestResponse toResponse(ReservationRequestDto dto) {
        return ReservationRequestResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .status(dto.getStatus())
                .animal(dto.getAnimal())
                .startDate(dto.getStartDate())
                .customer(dto.getCustomer())
                .endDate(dto.getEndDate())
                .build();
    }
}

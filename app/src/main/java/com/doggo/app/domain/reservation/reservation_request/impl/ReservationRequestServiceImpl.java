package com.doggo.app.domain.reservation.reservation_request.impl;

import com.doggo.app.domain.reservation.reservation_request.api.ReservationRequestDto;
import com.doggo.app.domain.reservation.reservation_request.api.ReservationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationRequestServiceImpl implements ReservationRequestService {
    private final ReservationRequestRepository repository;
    @Override
    @Transactional
    public ReservationRequestDto createReservationRequest(ReservationRequestDto dto) {
      return toDto(repository.save(toEntity(new ReservationRequest(),dto)));
    }


    @Override
    public List<ReservationRequestDto> getReservationRequests() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ReservationRequestDto getReservationRequest(String id) {
        return toDto(repository.findById(id).orElseThrow());
    }
    private ReservationRequest toEntity(ReservationRequest reservationRequest, ReservationRequestDto dto) {
        reservationRequest.setAnimalId(dto.getAnimalId());
        reservationRequest.setCustomerId(dto.getCustomerId());
        reservationRequest.setAnimalId(dto.getAnimalId());
        reservationRequest.setStartDate(dto.getStartDate());
        reservationRequest.setEndDate(dto.getEndDate());
        reservationRequest.setStatus(dto.getStatus());
        return reservationRequest;
    }

    private ReservationRequestDto toDto(ReservationRequest reservationRequest) {
        return ReservationRequestDto.builder()
                .id(reservationRequest.getId())
                .created(reservationRequest.getCreated())
                .modified(reservationRequest.getModified())
                .animalId(reservationRequest.getAnimalId())
                .customerId(reservationRequest.getAnimalId())
                .startDate(reservationRequest.getStartDate())
                .endDate(reservationRequest.getEndDate())
                .status(reservationRequest.getStatus())
                .build();
    }
}

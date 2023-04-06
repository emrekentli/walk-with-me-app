package com.doggo.app.domain.reservation.reservation.impl;

import com.doggo.app.domain.reservation.reservation.api.ReservationDto;
import com.doggo.app.domain.reservation.reservation.api.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository repository;
    @Override
    @Transactional
    public ReservationDto createReservation(ReservationDto dto) {
      return toDto(repository.save(toEntity(new Reservation(),dto)));
    }


    @Override
    public List<ReservationDto> getReservations() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ReservationDto getReservation(String id) {
        return toDto(repository.findById(id).orElseThrow());
    }
    private Reservation toEntity(Reservation reservation,ReservationDto dto) {
        reservation.setAnimalId(dto.getAnimalId());
        reservation.setWalkerId(dto.getWalkerId());
        reservation.setRequestId(dto.getRequestId());
        reservation.setStartDate(dto.getStartDate());
        reservation.setEndDate(dto.getEndDate());
        reservation.setStatus(dto.getStatus());
        return reservation;
    }

    private ReservationDto toDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .created(reservation.getCreated())
                .modified(reservation.getModified())
                .animalId(reservation.getAnimalId())
                .walkerId(reservation.getWalkerId())
                .requestId(reservation.getRequestId())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .status(reservation.getStatus())
                .build();
    }
}

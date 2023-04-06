package com.doggo.app.domain.walk.impl;

import com.doggo.app.domain.reservation.reservation.impl.Reservation;
import com.doggo.app.domain.reservation.reservation.impl.ReservationServiceImpl;
import com.doggo.app.domain.reservation.reservation.impl.ReservationStatus;
import com.doggo.app.domain.walk.api.WalkDto;
import com.doggo.app.domain.walk.api.WalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalkServiceImpl implements WalkService {
    private final WalkRepository repository;

    private final ReservationServiceImpl reservationService;
    @Override
    public WalkDto createWalk(WalkDto dto) {
        checkWalkExists(dto);
        Reservation reservation = reservationService.getReservationEntity(dto.getReservationDto().getId());
        checkReservationTimeLeft5Minute(reservation);
        Walk walk = repository.save(toEntity(new Walk(),dto));
        reservation.setStatus(ReservationStatus.ACTIVE);
        reservationService.updateReservation(reservation);
        return toDto(walk);
    }

    private void checkWalkExists(WalkDto dto) {
    repository.findAllByReservationId(dto.getReservationDto().getId())
            .stream()
            .findFirst()
            .ifPresent(walk -> {
                throw new EntityExistsException("Walk already exists");
            });
    }


    @Override
    public List<WalkDto> getWalks() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public WalkDto getWalk(String id) {
        return toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public WalkDto updateWalk(String id, WalkDto toDto) {
    return toDto(repository.save(toEntity(repository.findById(id).orElseThrow(EntityNotFoundException::new),toDto)));
    }

    private Walk toEntity(Walk walk, WalkDto dto) {
        walk.setReservationId(dto.getReservationDto().getId());
        walk.setStartDate(dto.getStartDate());
        walk.setEndDate(dto.getEndDate());
        walk.setDuration(0.0);
        walk.setDistance(0.0);
        return walk;
    }
    private WalkDto toDto(Walk walk) {
        return WalkDto.builder()
                .id(walk.getId())
                .reservationDto(reservationService.getReservation(walk.getReservationId()))
                .startDate(walk.getStartDate())
                .endDate(walk.getEndDate())
                .duration(walk.getDuration())
                .distance(walk.getDistance())
                .build();

    }
    private void checkReservationTimeLeft5Minute(Reservation reservation) {
        Date startDate = reservation.getStartDate();
        Date nowPlus5Minutes = Date.from(LocalDateTime.now().plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant());
        if (startDate.after(nowPlus5Minutes)) {
            throw new IllegalArgumentException("Reservation time is more than 5 minutes");
        }
    }
}

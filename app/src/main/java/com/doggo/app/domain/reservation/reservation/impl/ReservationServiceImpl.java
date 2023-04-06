package com.doggo.app.domain.reservation.reservation.impl;

import com.doggo.app.domain.people.walker.api.WalkerService;
import com.doggo.app.domain.reservation.reservation.api.ReservationDto;
import com.doggo.app.domain.reservation.reservation.api.ReservationService;
import com.doggo.app.domain.reservation.reservation_request.impl.ReservationRequest;
import com.doggo.app.domain.reservation.reservation_request.impl.ReservationRequestServiceImpl;
import com.doggo.app.domain.reservation.reservation_request.impl.ReservationRequestStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository repository;
    private final WalkerService walkerService;
    private final ReservationRequestServiceImpl reservationRequestService;
    @Override
    @Transactional
    public ReservationDto createReservation(ReservationDto dto) {
      checkWalkerHasNoReservationInBetweenDates(dto);
      Reservation reservation = repository.save(toEntity(new Reservation(),dto));
      ReservationRequest reservationRequest = reservationRequestService.getReservationRequestEntity(dto.getRequestDto().getId());
      reservationRequest.setStatus(ReservationRequestStatus.APPROVE);
      reservationRequestService.updateReservationRequest(reservationRequest);
      return toDto(reservation);
    }

    private void checkWalkerHasNoReservationInBetweenDates(ReservationDto dto) {
        repository.findAllByWalkerIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(dto.getWalkerDto().getId(),dto.getStartDate(),dto.getEndDate())
                .stream()
                .findFirst()
                .ifPresent(reservation -> {
                    throw new EntityExistsException("Walker has a reservation in between the dates");
                });

    }

    @Override
    public List<ReservationDto> getReservations() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ReservationDto getReservation(String id) {
        return toDto(repository.findById(id).orElseThrow());
    }
    public Reservation getReservationEntity(String id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new );
    }
    public ReservationDto updateReservation( Reservation reservation) {
        return toDto(repository.save(reservation));
    }
    private Reservation toEntity(Reservation reservation,ReservationDto dto) {
        reservation.setWalkerId(dto.getWalkerDto().getId());
        reservation.setRequestId(dto.getRequestDto().getId());
        reservation.setStatus(dto.getStatus());
        reservation.setStartDate(dto.getStartDate());
        reservation.setEndDate(dto.getEndDate());
        return reservation;
    }

    private ReservationDto toDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .created(reservation.getCreated())
                .modified(reservation.getModified())
                .walkerDto(walkerService.getWalker(reservation.getWalkerId()))
                .requestDto(reservationRequestService.getReservationRequest(reservation.getRequestId()))
                .status(reservation.getStatus())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .build();
    }
}

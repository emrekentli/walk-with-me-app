package com.doggo.app.domain.reservation.reservation_request.impl;

import com.doggo.app.domain.animal.api.AnimalService;
import com.doggo.app.domain.people.customer.api.CustomerService;
import com.doggo.app.domain.reservation.reservation_request.api.ReservationRequestDto;
import com.doggo.app.domain.reservation.reservation_request.api.ReservationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationRequestServiceImpl implements ReservationRequestService {
    private final ReservationRequestRepository repository;
    private final AnimalService animalService;
    private final CustomerService customerService;

    @Override
    @Transactional
    public ReservationRequestDto createReservationRequest(ReservationRequestDto dto) {
        checkIfReservationRequestExists(dto);
        return toDto(repository.save(toEntity(new ReservationRequest(), dto)));
    }

    @Override
    public List<ReservationRequestDto> getReservationRequests() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ReservationRequestDto getReservationRequest(String id) {
        return toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public ReservationRequestDto updateReservationRequest(String id, ReservationRequestDto dto) {
        return repository.findById(id)
                .map(reservationRequest -> toEntity(reservationRequest, dto))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }
    public ReservationRequestDto updateReservationRequest(ReservationRequest reservationRequest){
        return toDto(repository.save(reservationRequest));
    }
    public ReservationRequest getReservationRequestEntity(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<ReservationRequestDto> getReservationRequestsByCustomer(String id) {
        return repository.findAllByCustomerId(id).stream().map(this::toDto).toList();
    }

    private ReservationRequest toEntity(ReservationRequest reservationRequest, ReservationRequestDto dto) {
        reservationRequest.setAnimalId(dto.getAnimal().getId());
        reservationRequest.setCustomerId(dto.getCustomer().getId());
        reservationRequest.setStartDate(dto.getStartDate());
        reservationRequest.setEndDate(dto.getEndDate());
        reservationRequest.setStatus(dto.getStatus());
        return reservationRequest;
    }

    private void checkIfReservationRequestExists(ReservationRequestDto dto) {
        if (repository.existsByAnimalIdAndCustomerIdAndStartDateAndEndDate(dto.getAnimal().getId(), dto.getCustomer().getId(), dto.getStartDate(), dto.getEndDate())) {
            throw new RuntimeException("ReservationRequest already exists");
        }
    }

    private ReservationRequestDto toDto(ReservationRequest reservationRequest) {
        return ReservationRequestDto.builder()
                .id(reservationRequest.getId())
                .created(reservationRequest.getCreated())
                .modified(reservationRequest.getModified())
                .animal(animalService.getAnimal(reservationRequest.getAnimalId()))
                .customer(customerService.getCustomer(reservationRequest.getCustomerId()))
                .startDate(reservationRequest.getStartDate())
                .endDate(reservationRequest.getEndDate())
                .status(reservationRequest.getStatus())
                .build();
    }
}

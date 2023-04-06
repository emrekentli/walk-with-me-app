package com.doggo.app.domain.reservation.reservation.web;

import com.doggo.app.domain.reservation.reservation.api.ReservationDto;
import com.doggo.app.domain.reservation.reservation.api.ReservationService;
import com.doggo.core.rest.BaseController;
import com.doggo.core.rest.DataResponse;
import com.doggo.core.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "reservations")
@RequiredArgsConstructor
public class ReservationController extends BaseController {
    private final ReservationService service;
    @PostMapping
    public Response<ReservationResponse> createReservation(@Valid @RequestBody ReservationRequest request) {
      var reservation = service.createReservation(request.toDto());
      return respond(ReservationResponse.toResponse(reservation));
    }
    @GetMapping
    public Response<DataResponse<ReservationResponse>> getReservations() {
        List<ReservationDto> reservations = service.getReservations();
        return respond(toResponse(reservations));
    }
    @GetMapping("/{id}")
    public Response<ReservationResponse> getReservation(@PathVariable String id) {
        var reservation = service.getReservation(id);
        return respond(ReservationResponse.toResponse(reservation));
    }
    private List<ReservationResponse> toResponse(List<ReservationDto> reservationDtos) {
        return reservationDtos.stream().map(ReservationDto::toResponse).toList();
    }

}

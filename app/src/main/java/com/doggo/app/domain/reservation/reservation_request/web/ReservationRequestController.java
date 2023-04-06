package com.doggo.app.domain.reservation.reservation_request.web;

import com.doggo.app.domain.reservation.reservation_request.api.ReservationRequestDto;
import com.doggo.app.domain.reservation.reservation_request.api.ReservationRequestService;
import com.doggo.core.rest.BaseController;
import com.doggo.core.rest.DataResponse;
import com.doggo.core.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "reservation-requests")
@RequiredArgsConstructor
public class ReservationRequestController extends BaseController {
    private final ReservationRequestService service;
    @PostMapping
    public Response<ReservationRequestResponse> createReservationRequest(@Valid @RequestBody ReservationRequestRequest request) {
      var reservationRequest = service.createReservationRequest(request.toDto());
      return respond(ReservationRequestResponse.toResponse(reservationRequest));
    }
    @PutMapping("/{id}")
    public Response<ReservationRequestResponse> updateReservationRequest(@PathVariable String id, @Valid @RequestBody ReservationRequestRequest request) {
        var reservationRequest = service.updateReservationRequest(id, request.toDto());
        return respond(ReservationRequestResponse.toResponse(reservationRequest));
    }
    @GetMapping
    public Response<DataResponse<ReservationRequestResponse>> getReservationRequests() {
        List<ReservationRequestDto> reservationRequests = service.getReservationRequests();
        return respond(toResponse(reservationRequests));
    }
    @GetMapping("/customer/{id}")
    public Response<DataResponse<ReservationRequestResponse>> getReservationRequestsByCustomer(@PathVariable String id) {
        List<ReservationRequestDto> reservationRequests = service.getReservationRequestsByCustomer(id);
        return respond(toResponse(reservationRequests));
    }
    @GetMapping("/{id}")
    public Response<ReservationRequestResponse> getReservationRequest(@PathVariable String id) {
        var reservation = service.getReservationRequest(id);
        return respond(ReservationRequestResponse.toResponse(reservation));
    }
    private List<ReservationRequestResponse> toResponse(List<ReservationRequestDto> reservationRequestDtos) {
        return reservationRequestDtos.stream().map(ReservationRequestDto::toResponse).toList();
    }

}

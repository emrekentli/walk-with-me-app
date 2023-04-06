package com.doggo.app.domain.people.customer.web;

import com.doggo.app.domain.people.customer.api.CustomerDto;
import com.doggo.app.domain.people.customer.api.CustomerService;
import com.doggo.core.rest.BaseController;
import com.doggo.core.rest.DataResponse;
import com.doggo.core.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "customers")
@RequiredArgsConstructor
public class CustomerController  extends BaseController {
    private final CustomerService service;
    @PostMapping
    public Response<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest request) {
      var customer = service.createReservation(request.toDto());
      return respond(CustomerResponse.toResponse(customer));
    }
    @GetMapping
    public Response<DataResponse<CustomerResponse>> getCustomers() {
        List<CustomerDto> customers = service.getCustomers();
        return respond(toResponse(customers));
    }
    private List<CustomerResponse> toResponse(List<CustomerDto> customerDtos) {
        return customerDtos.stream().map(CustomerDto::toResponse).toList();
    }

}

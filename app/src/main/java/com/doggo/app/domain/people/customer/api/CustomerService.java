package com.doggo.app.domain.people.customer.api;

import java.util.List;

public interface CustomerService {
    CustomerDto createReservation(CustomerDto dto);

    List<CustomerDto> getCustomers();

    CustomerDto getCustomer(String customerId);
}

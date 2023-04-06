package com.doggo.app.domain.people.customer.impl;

import com.doggo.app.domain.people.customer.api.CustomerDto;
import com.doggo.app.domain.people.customer.api.CustomerService;
import com.doggo.app.domain.people.user.api.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    private final UserClient userClient;
    @Override
    @Transactional
    public CustomerDto createReservation(CustomerDto dto) {
      var user = userClient.createUser(dto.getUser());
      Customer customer = new Customer();
      customer.setUserId(user.getId());
      return toDto(repository.save(customer));
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public CustomerDto getCustomer(String customerId) {
        return toDto(repository.findById(customerId).orElseThrow());
    }

    private CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .user(userClient.getUserById(customer.getUserId()))
                .created(customer.getCreated())
                .modified(customer.getModified())
                .build();
    }
}

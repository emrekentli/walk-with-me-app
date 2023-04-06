package com.doggo.app.domain.people.customer.web;

import com.doggo.app.domain.people.customer.api.CustomerDto;
import com.doggo.app.domain.people.user.api.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CustomerResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final UserDto user;

    public static CustomerResponse toResponse(CustomerDto customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .created(customer.getCreated())
                .modified(customer.getModified())
                .user(customer.getUser())
                .build();
    }
}

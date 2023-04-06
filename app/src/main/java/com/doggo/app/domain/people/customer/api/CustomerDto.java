package com.doggo.app.domain.people.customer.api;

import com.doggo.app.domain.people.customer.web.CustomerResponse;
import com.doggo.app.domain.people.user.api.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class CustomerDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final UserDto user;
    private final String userId;

    public static CustomerResponse toResponse(CustomerDto dto) {
        return CustomerResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .user(dto.getUser())
                .build();
    }
}

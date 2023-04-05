package com.doggo.app.domain.people.customer.api;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class CustomerDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String surname;
    private final String email;
    private final String phone;
    private final Date birthDate;
    private final String userId;
    private final String city;
}

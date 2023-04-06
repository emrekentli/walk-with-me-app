package com.doggo.app.domain.people.user.api;
import com.doggo.app.domain.people.customer.impl.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
    private final String surname;
    private final String password;
    private final String email;
    private final String phoneNumber;
    private final Date birthDate;
    private final String city;
    private final Gender gender;
}

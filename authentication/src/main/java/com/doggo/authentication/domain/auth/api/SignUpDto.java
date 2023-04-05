package com.doggo.authentication.domain.auth.api;

import com.doggo.authentication.domain.user.impl.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SignUpDto {
    private final String name;
    private final String surname;
    private final String password;
    private final String email;
    private final String phoneNumber;
    private final Date birthDate;
    private final String city;
    private final Gender gender;
}

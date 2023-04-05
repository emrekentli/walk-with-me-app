package com.doggo.app.domain.people.customer.web;

import com.doggo.app.domain.people.customer.impl.Gender;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Builder
public class CustomerRequest {
   @NotBlank
    private final String name;
    @NotBlank
    private final String surname;
    @NotBlank
    private final String email;
    @NotBlank
    private final String password;
    @NotBlank
    private final String phone;
    @NotBlank
    private final Date birthDate;
    @NotBlank
    private final String city;
    @NotBlank
    private final Gender gender;
}

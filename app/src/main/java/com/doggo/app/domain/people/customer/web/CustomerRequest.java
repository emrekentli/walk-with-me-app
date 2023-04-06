package com.doggo.app.domain.people.customer.web;

import com.doggo.app.domain.people.customer.api.CustomerDto;
import com.doggo.app.domain.people.customer.impl.Gender;
import com.doggo.app.domain.people.user.api.UserDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    private final String phoneNumber;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final  Date birthDate;
    @NotBlank
    private final String city;
    @NotNull
    private final Gender gender;

 public CustomerDto toDto() {
  return CustomerDto.builder()
          .user(UserDto.builder()
                  .name(name)
                  .surname(surname)
                  .email(email)
                  .city(city)
                  .birthDate(birthDate)
                  .gender(gender)
                  .password(password)
                  .phoneNumber(phoneNumber)
                  .build())
          .build();
 }
}

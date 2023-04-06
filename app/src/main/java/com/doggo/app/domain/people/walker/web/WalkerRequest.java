package com.doggo.app.domain.people.walker.web;

import com.doggo.app.domain.people.customer.impl.Gender;
import com.doggo.app.domain.people.user.api.UserDto;
import com.doggo.app.domain.people.walker.api.WalkerDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class WalkerRequest {
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

 public WalkerDto toDto() {
  return WalkerDto.builder()
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

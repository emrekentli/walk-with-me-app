package com.doggo.authentication.domain.user.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
}

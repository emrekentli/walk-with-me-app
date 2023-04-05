package com.doggo.authentication.domain.auth.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String emailAddress;
}

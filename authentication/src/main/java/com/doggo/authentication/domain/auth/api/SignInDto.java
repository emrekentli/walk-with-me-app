package com.doggo.authentication.domain.auth.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInDto  {
    private String phoneNumber;
    private String password;
}

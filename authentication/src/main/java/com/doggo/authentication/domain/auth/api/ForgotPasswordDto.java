package com.doggo.authentication.domain.auth.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForgotPasswordDto {
    private String phoneNumber;
}
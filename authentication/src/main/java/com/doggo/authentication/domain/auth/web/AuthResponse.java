package com.doggo.authentication.domain.auth.web;

import com.doggo.authentication.domain.user.api.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {

    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;


    public static AuthResponse fromDto(UserDto dto) {
        return AuthResponse.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phoneNumber(dto.getPhoneNumber())
                .emailAddress(dto.getEmailAddress())
                .build();
    }
}

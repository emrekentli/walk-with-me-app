package com.doggo.authentication.domain.auth.web;

import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.authentication.domain.user.impl.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AuthResponse {

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


    public static AuthResponse fromDto(UserDto dto) {
        return AuthResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .city(dto.getCity())
                .birthDate(dto.getBirthDate())
                .gender(dto.getGender())
                .build();
    }
}

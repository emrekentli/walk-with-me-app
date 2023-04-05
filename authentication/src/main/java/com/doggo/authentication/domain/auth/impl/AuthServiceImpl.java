package com.doggo.authentication.domain.auth.impl;

import com.doggo.authentication.domain.auth.api.AuthService;
import com.doggo.authentication.domain.auth.api.ForgotPasswordDto;
import com.doggo.authentication.domain.auth.api.SignInDto;
import com.doggo.authentication.domain.auth.api.SignUpDto;
import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.authentication.domain.user.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    @Override
    public UserDto signIn(SignInDto dto) throws Exception {
        UserDto userDto = userService.getUserByCreadentional(dto);
        return userDto;
    }

    @Override
    public UserDto signUp(SignUpDto dto) {
        UserDto userDto = UserDto.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .city(dto.getCity())
                .birthDate(dto.getBirthDate())
                .gender(dto.getGender())
                .build();
        return userService.createUser(userDto);
    }

    @Override
    public UserDto forgotPassword(ForgotPasswordDto dto) {
        //TODO impl this logics
        return null;

    }

}

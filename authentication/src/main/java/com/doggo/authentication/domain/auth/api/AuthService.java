package com.doggo.authentication.domain.auth.api;

import com.doggo.authentication.domain.user.api.UserDto;

public interface AuthService {
    UserDto signIn(SignInDto dto) throws Exception;

    UserDto signUp(SignUpDto dto);

    UserDto forgotPassword(ForgotPasswordDto dto);
}

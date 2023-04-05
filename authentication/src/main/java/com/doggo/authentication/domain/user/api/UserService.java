package com.doggo.authentication.domain.user.api;

import com.doggo.authentication.domain.auth.api.SignInDto;

public interface UserService {
    UserDto createUser(UserDto dto);

    UserDto getUserById(String userId);

    UserDto getByPhoneNumber(String userName);

    UserDto getUserByCreadentional(SignInDto dto) throws Exception;

}

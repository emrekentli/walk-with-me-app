package com.doggo.authentication.domain.user.api;


public interface UserService {
    UserDto createUser(UserDto dto);

    UserDto getUserById(String userId);

    UserDto getByPhoneNumber(String userName);

}

package com.doggo.app.domain.people.user.api;

public interface UserClient {
    UserDto createUser(UserDto dto);

    UserDto getUserById(String id);
}

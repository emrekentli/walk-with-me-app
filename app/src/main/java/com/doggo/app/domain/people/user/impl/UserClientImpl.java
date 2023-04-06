package com.doggo.app.domain.people.user.impl;

import com.doggo.app.domain.people.user.api.UserClient;
import com.doggo.app.domain.people.user.api.UserDto;
import com.doggo.app.library.feignclient.UserFeignCallableApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserClientImpl implements UserClient {
    private final UserFeignCallableApi userFeignCallableApi;
    @Override
    public UserDto createUser(UserDto dto) {
        return userFeignCallableApi.createUser(dto);
    }

    @Override
    public UserDto getUserById(String id) {
        return userFeignCallableApi.getById(id);
    }
}

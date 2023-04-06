package com.doggo.app.library.feignclient;

import com.doggo.app.domain.people.user.api.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserFeignCallableApi {
    @PostMapping("/users")
    UserDto createUser(@RequestBody UserDto dto);
    @GetMapping("/users/{id}")
    UserDto getById(@PathVariable(value = "id") String id);
}

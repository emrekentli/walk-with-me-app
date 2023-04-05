package com.doggo.authentication.domain.user.web;

import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.authentication.domain.user.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @PostMapping
    public UserDto save(@RequestBody UserDto dto) {
        return service.createUser(dto);
    }
}

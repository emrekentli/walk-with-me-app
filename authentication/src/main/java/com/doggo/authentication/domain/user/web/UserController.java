package com.doggo.authentication.domain.user.web;

import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.authentication.domain.user.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @PostMapping
    public UserDto save(@RequestBody UserDto dto) {
        return service.createUser(dto);
    }
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable String id) {
        return service.getUserById(id);
    }
}

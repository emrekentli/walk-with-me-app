package com.doggo.authentication.domain.user.impl;
import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.authentication.domain.user.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto createUser(UserDto dto) {
        repository.findUserByPhoneNumber(dto.getPhoneNumber())
                .ifPresent(user -> {
                    throw new EntityExistsException("User already exists");
                });
        return repository.save(setUser(dto)).toDto();
    }

    @Override
    public UserDto getUserById(String userId) {
        return repository.findById(userId)
                .orElseThrow(EntityNotFoundException::new)
                .toDto();
    }

    @Override
    public UserDto getByPhoneNumber(String userName) {
        return repository.findUserByPhoneNumber(userName)
                .orElseThrow(EntityNotFoundException::new)
                .toDto();
    }



    private User setUser(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(dto.getPassword());
        user.setEmailAddress(dto.getEmail());
        user.setSurname(dto.getSurname());
        user.setBirthDate(dto.getBirthDate());
        user.setCity(dto.getCity());
        user.setGender(dto.getGender());
        return user;
    }

}

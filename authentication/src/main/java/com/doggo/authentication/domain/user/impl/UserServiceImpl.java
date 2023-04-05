package com.doggo.authentication.domain.user.impl;

import com.doggo.authentication.domain.auth.api.SignInDto;
import com.doggo.authentication.domain.auth.api.exception.UserAlreadyException;
import com.doggo.authentication.domain.auth.api.exception.UserValidationException;
import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.authentication.domain.user.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto createUser(UserDto dto) {
        User user = null;
        try {
            user = repository.findUserByPhoneNumber(dto.getPhoneNumber()).get();
            if (user != null) {
                throw new UserAlreadyException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            user = setUser(dto);
        }

        return repository.save(user).toDto();
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

    @Override
    public UserDto getUserByCreadentional(SignInDto dto) throws Exception {
        UserDto userDto =
                repository.findUserByPhoneNumberAndPassword(dto.getPhoneNumber(), dto.getPassword())
                        .orElseThrow(UserValidationException::new)
                        .toDto();
        return userDto;
    }


    private User setUser(UserDto dto) {
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmailAddress(dto.getEmailAddress());
        return user;
    }

}

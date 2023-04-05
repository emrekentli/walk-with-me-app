package com.doggo.authentication.domain.user.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByPhoneNumber(String phoneNumber);
    Optional<User> findUserByPhoneNumberAndPassword(String userName, String password);
}

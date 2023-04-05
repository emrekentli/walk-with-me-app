package com.doggo.authentication.domain.user.impl;

import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.core.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usr")
public class User extends AbstractEntity {
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public UserDto toDto() {
        return UserDto.builder()
                .id(this.getId())
                .password(this.getPassword())
                .firstName(this.firstName)
                .lastName(this.lastName)
                .emailAddress(this.emailAddress)
                .phoneNumber(this.phoneNumber)
                .build();
    }

}

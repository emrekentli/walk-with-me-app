package com.doggo.authentication.domain.user.impl;

import com.doggo.authentication.domain.user.api.UserDto;
import com.doggo.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = User.TABLE)
public class User extends AbstractEntity {
    public static final String TABLE = "usr";
    public static final String COL_NAME = "name";
    public static final String COL_SURNAME = "surname";
    public static final String COL_PASSWORD = "password";
    public static final String COL_PHONE = "phone_number";
    public static final String COL_EMAIL = "email_address";
    public static final String COL_BIRTH = "birth_date";
    public static final String COL_CITY = "city";
    public static final String COL_GENDER = "gender";
    @Column(name = COL_NAME, nullable = false)
    private String name;

    @Column(name = COL_SURNAME, nullable = false)
    private String surname;
    @Column(name = COL_PASSWORD, nullable = false)
    private String password;
    @Column(name = COL_PHONE, nullable = false)
    private String phoneNumber;
    @Column(name = COL_EMAIL, nullable = false)
    private String emailAddress;
    @Column(name = COL_BIRTH, nullable = false)
    private Date birthDate;
    @Column(name = COL_CITY, nullable = false)
    private String city;
    @Enumerated(EnumType.STRING)
    @Column(name = COL_GENDER, nullable = false)
    private Gender gender;


    public UserDto toDto() {
        return UserDto.builder()
                .id(this.getId())
                .created(this.getCreated())
                .modified(this.getModified())
                .name(this.name)
                .surname(this.surname)
                .email(this.emailAddress)
                .phoneNumber(this.phoneNumber)
                .password(this.password)
                .gender(this.getGender())
                .birthDate(this.birthDate)
                .city(this.city)
                .build();
    }

}

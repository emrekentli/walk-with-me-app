package com.doggo.app.domain.people.walker.web;

import com.doggo.app.domain.people.user.api.UserDto;
import com.doggo.app.domain.people.walker.api.WalkerDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class WalkerResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final UserDto user;

    public static WalkerResponse toResponse(WalkerDto walkerDto) {
        return WalkerResponse.builder()
                .id(walkerDto.getId())
                .created(walkerDto.getCreated())
                .modified(walkerDto.getModified())
                .user(walkerDto.getUser())
                .build();
    }
}

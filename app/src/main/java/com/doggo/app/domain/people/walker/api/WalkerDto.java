package com.doggo.app.domain.people.walker.api;
import com.doggo.app.domain.people.user.api.UserDto;
import com.doggo.app.domain.people.walker.web.WalkerResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class WalkerDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final UserDto user;
    private final String userId;

    public static WalkerResponse toResponse(WalkerDto dto) {
        return WalkerResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .user(dto.getUser())
                .build();
    }
}

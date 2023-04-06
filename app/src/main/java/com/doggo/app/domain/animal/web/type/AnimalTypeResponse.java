package com.doggo.app.domain.animal.web.type;
import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AnimalTypeResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;

    public static AnimalTypeResponse toResponse(AnimalTypeDto dto){
        return AnimalTypeResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .name(dto.getName())
                .build();
    }
}

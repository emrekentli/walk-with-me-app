package com.doggo.app.domain.animal.web.type;
import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class AnimalTypeRequest {
    @NotBlank
    private final String name;

    public AnimalTypeRequest(@JsonProperty("name") String name) {
        this.name = name;
    }
    public AnimalTypeDto toDto(){
        return AnimalTypeDto.builder()
                .name(name)
                .build();
    }
}

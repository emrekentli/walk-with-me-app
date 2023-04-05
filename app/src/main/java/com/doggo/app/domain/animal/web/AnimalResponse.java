package com.doggo.app.domain.animal.web;

import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AnimalResponse {
    private final String id;
    private final Date created;
    private final Date modified;
    private final Double weight;
    private final Integer age;
    private final String customerId;
    private final AnimalTypeDto animalType;
    private String breed;

    public static AnimalResponse fromDto(AnimalDto dto){
        return AnimalResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .weight(dto.getWeight())
                .animalType(dto.getAnimalType())
                .customerId(dto.getCustomerId())
                .age(dto.getAge())
                .breed(dto.getBreed())
                .build();
    }
}

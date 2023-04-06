package com.doggo.app.domain.animal.web;

import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import com.doggo.app.domain.people.customer.api.CustomerDto;
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
    private final CustomerDto customer;
    private final AnimalTypeDto animalType;
    private String breed;

    public static AnimalResponse fromDto(AnimalDto dto){
        return AnimalResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .weight(dto.getWeight())
                .animalType(dto.getAnimalType())
                .customer(dto.getCustomer())
                .age(dto.getAge())
                .breed(dto.getBreed())
                .build();
    }
}

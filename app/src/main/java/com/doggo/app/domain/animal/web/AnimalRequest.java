package com.doggo.app.domain.animal.web;
import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalRequest {
    private final Double weight;
    private final Integer age;
    private final String customerId;
    private final AnimalTypeDto animalType;
    private String breed;

    public AnimalDto toDto(){
        return AnimalDto.builder()
                .animalType(animalType)
                .customerId(customerId)
                .weight(weight)
                .age(age)
                .breed(breed)
                .build();
    }
}

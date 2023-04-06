package com.doggo.app.domain.animal.web;
import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import com.doggo.app.domain.people.customer.api.CustomerDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class AnimalRequest {
    private final Double weight;
    private final Integer age;
    @NotBlank
    private final String customerId;
    private final AnimalTypeDto animalType;
    private String breed;

    public AnimalDto toDto(){
        return AnimalDto.builder()
                .animalType(animalType)
                .customer(CustomerDto.builder().id(customerId).build())
                .weight(weight)
                .age(age)
                .breed(breed)
                .build();
    }
}

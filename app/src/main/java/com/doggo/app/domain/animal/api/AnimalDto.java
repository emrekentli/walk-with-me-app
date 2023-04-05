package com.doggo.app.domain.animal.api;
import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AnimalDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final Double weight;
    private final Integer age;
    private final String customerId;
    private final AnimalTypeDto animalType;
    private String breed;
}

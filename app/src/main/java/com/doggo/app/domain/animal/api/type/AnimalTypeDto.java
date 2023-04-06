package com.doggo.app.domain.animal.api.type;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AnimalTypeDto {
    private final String id;
    private final Date created;
    private final Date modified;
    private final String name;
}

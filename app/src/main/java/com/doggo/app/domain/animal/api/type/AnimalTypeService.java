package com.doggo.app.domain.animal.api.type;

import java.util.List;

public interface AnimalTypeService {
    AnimalTypeDto createAnimalType(AnimalTypeDto dto);

    List<AnimalTypeDto> getAllAnimalTypes();
    List<AnimalTypeDto> getAnimalTypes(AnimalTypeDto dto);

    AnimalTypeDto updateAnimalType(String id, AnimalTypeDto dto);

    void deleteAnimalType(String id);
}

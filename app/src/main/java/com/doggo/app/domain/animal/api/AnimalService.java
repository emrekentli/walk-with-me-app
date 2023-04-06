package com.doggo.app.domain.animal.api;

import java.util.List;

public interface AnimalService {
    AnimalDto createAnimal(AnimalDto dto);

    List<AnimalDto> getAllAnimals();

    AnimalDto updateAnimal(String id, AnimalDto dto);

    void deleteAnimal(String id);

    AnimalDto getAnimal(String id);

    List<AnimalDto> filterAnimals(AnimalDto animalDto);

    List<AnimalDto> getAnimalsByCustomerId(String id);
}

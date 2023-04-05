package com.doggo.app.domain.animal.impl;

import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.animal.api.AnimalService;
import com.doggo.app.domain.animal.impl.type.AnimalTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository repository;
    private final AnimalTypeServiceImpl animalTypeService;

    @Override
    @Transactional
    public AnimalDto createAnimal(AnimalDto dto) {
        return toDto(repository.save(toEntity(new Animal(),dto)));

    }

    @Override
    public List<AnimalDto> getAllAnimals() {
        return repository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional
    public AnimalDto updateAnimal(String id, AnimalDto dto) {
        Animal animal = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return toDto(repository.save(toEntity(animal, dto)));
    }

    @Override
    public void deleteAnimal(String id) {
        repository.delete(repository.findById(id).orElseThrow(EntityExistsException::new));
    }

    public Animal getAnimal(String id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Animal toEntity(Animal animal, AnimalDto dto) {
        animal.setWeight(dto.getWeight());
        animal.setAnimalType(animalTypeService.getEntityById(dto.getAnimalType().getId()));
        animal.setAge(dto.getAge());
        animal.setBreed(dto.getBreed());
        animal.setCustomerId(dto.getCustomerId());
        return animal;
    }

    public AnimalDto toDto(Animal animal) {
        return AnimalDto.builder()
                .id(animal.getId())
                .created(animal.getCreated())
                .modified(animal.getModified())
                .animalType(animalTypeService.toDto(animal.getAnimalType()))
                .weight(animal.getWeight())
                .age(animal.getAge())
                .breed(animal.getBreed())
                .customerId(animal.getCustomerId())
                .build();
    }
}
package com.doggo.app.domain.animal.impl;

import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.animal.api.AnimalService;
import com.doggo.app.domain.animal.impl.type.AnimalTypeServiceImpl;
import com.doggo.app.domain.people.customer.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
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
    private final CustomerServiceImpl customerService;

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

    public AnimalDto getAnimal(String id) {
        return toDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<AnimalDto> filterAnimals(AnimalDto animalDto) {
        Animal animal = toEntity(new Animal(),animalDto);
        return repository.findAll(Example.of(animal)).stream().map(this::toDto).toList();
    }

    @Override
    public List<AnimalDto> getAnimalsByCustomerId(String id) {
        return repository.findAllByCustomerId(id).stream()
                .map(this::toDto)
                .toList();
    }


    public Animal toEntity(Animal animal, AnimalDto dto) {
        animal.setWeight(dto.getWeight());
        animal.setAnimalType(animalTypeService.getEntityById(dto.getAnimalType().getId()));
        animal.setAge(dto.getAge());
        animal.setBreed(dto.getBreed());
        animal.setCustomerId(dto.getCustomer().getId());
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
                .customer(customerService.getCustomer(animal.getCustomerId()))
                .build();
    }
}
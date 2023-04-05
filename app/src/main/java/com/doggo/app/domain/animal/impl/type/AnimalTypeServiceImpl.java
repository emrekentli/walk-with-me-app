package com.doggo.app.domain.animal.impl.type;

import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import com.doggo.app.domain.animal.api.type.AnimalTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalTypeServiceImpl implements AnimalTypeService {
    private final AnimalTypeRepository repository;

    @Override
    public AnimalTypeDto createAnimalType(AnimalTypeDto dto) {
        AnimalType animalType = new AnimalType();
        return toDto(repository.save(toEntity(dto,animalType)));
    }

    @Override
    public List<AnimalTypeDto> getAllAnimalTypes() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public List<AnimalTypeDto> getAnimalTypes(AnimalTypeDto dto) {
        return repository.findAll(Example.of(toEntity(dto,new AnimalType()))).stream().map(this::toDto).toList();
    }

    @Override
    public AnimalTypeDto updateAnimalType(String id, AnimalTypeDto dto) {
        AnimalType animalType = getEntityById(id);
        animalType.setName(dto.getName());
        return toDto(repository.save(animalType));
    }

    public AnimalType getEntityById(String id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("AnimalType not found"));
    }
    @Override
    public void deleteAnimalType(String id) {
        AnimalType animalType = repository.findById(id).orElseThrow(EntityExistsException::new);
        repository.delete(animalType);
    }

    public AnimalType getAnimalTypeByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new EntityNotFoundException("AnimalType not found"));
    }

    public AnimalType toEntity(AnimalTypeDto dto, AnimalType animalType) {
        animalType.setName(dto.getName());
        return animalType;
    }

    public AnimalTypeDto toDto(AnimalType animalType){
        return AnimalTypeDto.builder()
                .id(animalType.getId())
                .created(animalType.getCreated())
                .modified(animalType.getModified())
                .name(animalType.getName())
                .build();
    }

}

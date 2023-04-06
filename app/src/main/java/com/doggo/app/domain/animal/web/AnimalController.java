package com.doggo.app.domain.animal.web;

import com.doggo.app.domain.animal.api.AnimalDto;
import com.doggo.app.domain.animal.api.AnimalService;
import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import com.doggo.core.rest.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "animals")
@RequiredArgsConstructor
public class AnimalController extends BaseController {
    private final AnimalService service;

    @GetMapping
    public Response<DataResponse<AnimalResponse>> getAllAnimals() {
        List<AnimalDto> animalList = service.getAllAnimals();
        return respond(toResponse(animalList));
    }

    @PostMapping
    public Response<AnimalResponse> createAnimal(@Valid @RequestBody AnimalRequest request) {
        var animal = service.createAnimal(request.toDto());
        return respond(AnimalResponse.fromDto(animal));
    }

    @PutMapping("/{id}")
    public Response<AnimalResponse> updateAnimal(@PathVariable(value = "id") String id,
            @Valid @RequestBody AnimalRequest request) {
        var animal = service.updateAnimal(id, request.toDto());
        return respond(AnimalResponse.fromDto(animal));
    }


    @DeleteMapping("/{id}")
    public Response<Void> deleteAnimal(@PathVariable(value = "id") String id) {
        service.deleteAnimal(id);
        return new Response<>(MetaResponse.ofSuccess());
    }
    @GetMapping("/{id}")
    public Response<AnimalResponse> getAnimal(@PathVariable(value = "id") String id) {
        var animal = service.getAnimal(id);
        return respond(AnimalResponse.fromDto(animal));
    }

    @GetMapping("/filter")
    public Response<DataResponse<AnimalResponse>> filterAnimals(
            @RequestParam(required = false) AnimalTypeDto animalTypeDto,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) String breed) {
        AnimalDto animalDto =
                AnimalDto.builder()
                        .animalType(animalTypeDto)
                        .breed(breed)
                        .weight(weight)
                        .build();
        return respond(toResponse(service.filterAnimals(animalDto)));
    }
    @GetMapping("/customers/{id}")
    public Response<DataResponse<AnimalResponse>> getAnimalsByCustomerId(@PathVariable(value = "id") String id) {
        return respond(toResponse(service.getAnimalsByCustomerId(id)));
    }

    private List<AnimalResponse> toResponse(List<AnimalDto> animalList) {
        return animalList.stream().map(AnimalResponse::fromDto).toList();
    }
}

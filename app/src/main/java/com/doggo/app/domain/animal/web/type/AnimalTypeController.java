package com.doggo.app.domain.animal.web.type;

import com.doggo.app.domain.animal.api.type.AnimalTypeDto;
import com.doggo.app.domain.animal.api.type.AnimalTypeService;
import com.doggo.core.rest.BaseController;
import com.doggo.core.rest.DataResponse;
import com.doggo.core.rest.MetaResponse;
import com.doggo.core.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "animal-types")
@RequiredArgsConstructor
public class AnimalTypeController extends BaseController {
    private final AnimalTypeService service;

    @PostMapping
    public Response<AnimalTypeResponse> createAnimalType(@RequestBody AnimalTypeRequest request) {
        AnimalTypeDto animalType = service.createAnimalType(request.toDto());
        return respond(AnimalTypeResponse.toResponse(animalType));
    }

    @GetMapping("/filter")
    public Response<DataResponse<AnimalTypeResponse>> getAnimalTypes(
            @RequestParam(required = false) String name) {
        AnimalTypeDto dto = AnimalTypeDto.builder()
                .name(name)
                .build();
        List<AnimalTypeDto> animalTypeList = service.getAnimalTypes(dto);
        return respond(toResponse(animalTypeList));
    }

    @GetMapping
    public Response<DataResponse<AnimalTypeResponse>> getAllAnimalTypes() {
        List<AnimalTypeDto> animalTypeList = service.getAllAnimalTypes();
        return respond(toResponse(animalTypeList));
    }

    @PutMapping("/{id}")
    public Response<AnimalTypeResponse> updateAnimalType(
            @PathVariable String id,
            @RequestBody AnimalTypeRequest request) {
        AnimalTypeDto animalType = service.updateAnimalType(id, request.toDto());
        return respond(AnimalTypeResponse.toResponse(animalType));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteAnimalType(@PathVariable(value = "id") String id) {
        service.deleteAnimalType(id);
        return new Response<>(MetaResponse.ofSuccess());
    }

    private List<AnimalTypeResponse> toResponse(List<AnimalTypeDto> animalTypeDtos) {
        return animalTypeDtos.stream()
                .map(AnimalTypeResponse::toResponse)
                .toList();
    }

}

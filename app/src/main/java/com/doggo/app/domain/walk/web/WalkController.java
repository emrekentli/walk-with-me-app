package com.doggo.app.domain.walk.web;

import com.doggo.app.domain.walk.api.WalkDto;
import com.doggo.app.domain.walk.api.WalkService;
import com.doggo.core.rest.BaseController;
import com.doggo.core.rest.DataResponse;
import com.doggo.core.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "walks")
@RequiredArgsConstructor
public class WalkController extends BaseController {
    private final WalkService service;

    @PostMapping
    public Response<WalkResponse> createWalk(@Valid @RequestBody WalkRequest request) {
        var walk = service.createWalk(request.toDto());
        return respond(WalkResponse.toResponse(walk));
    }
    @GetMapping
    public Response<DataResponse<WalkResponse>> getWalks() {
        List<WalkDto> walks = service.getWalks();
        return respond(toResponse(walks));
    }
    @PutMapping("/{id}")
    public Response<WalkResponse> updateWalk(@PathVariable String id, @Valid @RequestBody WalkRequest request) {
        var walk = service.updateWalk(id, request.toDto());
        return respond(WalkResponse.toResponse(walk));
    }
    @GetMapping("/{id}")
    public Response<WalkResponse> getWalk(@PathVariable String id) {
        var walk = service.getWalk(id);
        return respond(WalkResponse.toResponse(walk));
    }
    private List<WalkResponse> toResponse(List<WalkDto> walkDtos) {
        return walkDtos.stream().map(WalkDto::toResponse).toList();
    }
}

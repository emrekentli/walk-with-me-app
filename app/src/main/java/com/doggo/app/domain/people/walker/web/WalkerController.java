package com.doggo.app.domain.people.walker.web;

import com.doggo.app.domain.people.walker.api.WalkerDto;
import com.doggo.app.domain.people.walker.api.WalkerService;
import com.doggo.core.rest.BaseController;
import com.doggo.core.rest.DataResponse;
import com.doggo.core.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "walkers")
@RequiredArgsConstructor
public class WalkerController extends BaseController {
    private final WalkerService service;
    @PostMapping
    public Response<WalkerResponse> createWalker(@Valid @RequestBody WalkerRequest request) {
      var walker = service.createWalker(request.toDto());
      return respond(WalkerResponse.toResponse(walker));
    }
    @GetMapping
    public Response<DataResponse<WalkerResponse>> getWalkers() {
        List<WalkerDto> walkers = service.getWalkers();
        return respond(toResponse(walkers));
    }
    private List<WalkerResponse> toResponse(List<WalkerDto> walkerDtos) {
        return walkerDtos.stream().map(WalkerDto::toResponse).toList();
    }
}

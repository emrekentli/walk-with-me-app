package com.doggo.app.domain.walk.api;

import java.util.List;

public interface WalkService {
    WalkDto createWalk(WalkDto dto);

    List<WalkDto> getWalks();

    WalkDto getWalk(String id);

    WalkDto updateWalk(String id, WalkDto toDto);
}

package com.doggo.app.domain.people.walker.api;

import java.util.List;

public interface WalkerService {
    WalkerDto createWalker(WalkerDto dto);

    List<WalkerDto> getWalkers();

    WalkerDto getWalker(String id);
}

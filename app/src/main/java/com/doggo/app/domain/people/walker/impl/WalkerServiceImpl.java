package com.doggo.app.domain.people.walker.impl;

import com.doggo.app.domain.people.user.api.UserClient;
import com.doggo.app.domain.people.walker.api.WalkerDto;
import com.doggo.app.domain.people.walker.api.WalkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalkerServiceImpl implements WalkerService {
    private final WalkerRepository repository;

    private final UserClient userClient;
    @Override
    @Transactional
    public WalkerDto createWalker(WalkerDto dto) {
      var user = userClient.createUser(dto.getUser());
      Walker walker = new Walker();
      walker.setUserId(user.getId());
      return toDto(repository.save(walker));
    }

    @Override
    public List<WalkerDto> getWalkers() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    private WalkerDto toDto(Walker walker) {
        return WalkerDto.builder()
                .id(walker.getId())
                .user(userClient.getUserById(walker.getUserId()))
                .created(walker.getCreated())
                .modified(walker.getModified())
                .build();
    }
}

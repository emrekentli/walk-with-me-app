package com.doggo.app.domain.walk.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalkRepository  extends JpaRepository<Walk, String> {

    List<Walk> findAllByReservationId(String id);
}

package com.doggo.app.domain.animal.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, String> {
    List<Animal> findAllByCustomerId(String id);
}

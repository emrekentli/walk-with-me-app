package com.doggo.app.domain.animal.impl.type;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalTypeRepository extends JpaRepository<AnimalType,String> {
    Optional<AnimalType> findByName(String name);
}

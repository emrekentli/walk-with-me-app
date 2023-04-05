package com.doggo.app.domain.animal.impl;
import com.doggo.app.domain.animal.impl.type.AnimalType;
import com.doggo.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Animal.TABLE)
public class Animal extends AbstractEntity {
    public static final String TABLE = "animal";
    public static final String COL_ANIMAL_TYPE_ID = "animal_type_id";
    public static final String COL_WEIGHT = "weight";
    public static final String COL_AGE = "age";
    public static final String COL_BREED = "breed";
    public static final String COL_CUSTOMER = "customer_id";


    @OneToOne
    @JoinColumn(name = COL_ANIMAL_TYPE_ID)
    private AnimalType animalType;

    @Column(name = COL_WEIGHT, nullable = false)
    private Double weight;
    @Column(name = COL_AGE, nullable = false)
    private Integer age;
    @Column(name = COL_BREED, nullable = false)
    private String breed;
    @Column(name = COL_CUSTOMER, nullable = false)
    private String customerId;
}

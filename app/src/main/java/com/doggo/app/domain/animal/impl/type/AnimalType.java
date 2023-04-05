package com.doggo.app.domain.animal.impl.type;
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
@Table(name = AnimalType.TABLE)
public class AnimalType extends AbstractEntity {
    public static final String TABLE = "animal_type";
    public static final String COL_NAME = "name";

    @Column(name = COL_NAME, nullable = false)
    private String name;

}

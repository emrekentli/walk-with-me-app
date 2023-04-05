package com.doggo.app.domain.people.customer.impl;
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
@Table(name = Customer.TABLE)
public class Customer extends AbstractEntity {
    public static final String TABLE = "customer";
    public static final String COL_USER_ID = "user_id";
    @Column(name = COL_USER_ID, nullable = false)
    private String userId;

}

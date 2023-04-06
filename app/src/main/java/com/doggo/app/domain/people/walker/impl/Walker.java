package com.doggo.app.domain.people.walker.impl;

import com.doggo.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Walker.TABLE)
public class Walker extends AbstractEntity {
    public static final String TABLE = "walker";
    public static final String COL_USER_ID = "user_id";
    @Column(name = COL_USER_ID, nullable = false)
    private String userId;

}

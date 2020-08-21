package com.myproject.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "roles")
public class Role {
    @Id
    private String id;
    private String name;
    private String description;

    //@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    //private List<User> users;
}

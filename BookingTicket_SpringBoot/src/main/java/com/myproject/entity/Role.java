package com.myproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity(name = "roles")
public class Role {
	@Id
	private String id;
	private String name;
	private String description;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<User> users;
}

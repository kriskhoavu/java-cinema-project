package com.myproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "users")
public class User {
	@Id
	private String id;
	private String email;
	private String fullname;
	private String password;
	private String avatar;
	private String phone;
	private String address;
	private String website;
	private String facebook;

	@Column(name = "role_id")
	private String roleId;

	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;

	@OneToMany(mappedBy = "user")
	private Set<Ticket> tickets;
}

package com.myproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	@JoinColumn(name = "role_id", 
	insertable = false, updatable = false)
	private Role role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Ticket> tickets;
}

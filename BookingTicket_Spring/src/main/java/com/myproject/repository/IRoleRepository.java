package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, String> {
	Role findByName(String name);
}

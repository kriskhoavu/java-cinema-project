package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	public Role findByName(String name);
}

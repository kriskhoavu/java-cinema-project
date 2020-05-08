package com.myproject.repository;

import java.util.List;

import com.myproject.entity.Role;

public interface RoleRepository {
	public List<Role> findAll();

	public Role findById(String id);

	public void save(Role model);

	public void delete(String id);

	public List<Role> findNotAdmin();
}

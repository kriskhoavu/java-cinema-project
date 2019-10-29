package com.myproject.service;

import java.util.List;

import com.myproject.entity.Role;

public interface IRoleService {
	public List<Role> findAll();

	public Role findById(String id);

	public boolean insert(Role model);

	public boolean update(Role model);

	public void delete(String id);

	// public List<Role> findNotAdmin();
}

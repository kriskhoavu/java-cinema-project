package com.myproject.services;

import java.util.List;

import com.myproject.dto.RoleDto;

public interface IRoleService {
	public List<RoleDto> findAll();

	public RoleDto findById(String id);

	public void save(RoleDto model);

	public void update(RoleDto model);

	public void delete(String id);

	public List<RoleDto> findNotAdmin();
}

package com.myproject.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.repository.RoleRepository;
import com.myproject.dto.RoleDto;
import com.myproject.entity.Role;
import com.myproject.services.IRoleService;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository _roleRepository;

	public List<RoleDto> findAll() {
		// Khai báo danh sách RoleDTO trả về cho controller
		List<RoleDto> dtos = new ArrayList<RoleDto>();

		// Lấy danh sách Role từ tầng Repository
		List<Role> roles = this._roleRepository.findAll();

		// Lặp danh sách Role
		for (Role role : roles) {
			RoleDto dto = new RoleDto();

			dto.setId(role.getId());
			dto.setName(role.getName());
			dto.setDescription(role.getDescription());

			dtos.add(dto); // Thêm vào danh sách RoleDTO
		}
		return dtos; // Trả danh sách RoleDTO về cho COntroller
	}

	public void save(RoleDto model) {
		Role role = new Role();

		role.setId(UUID.randomUUID().toString());
		role.setName(model.getName());
		role.setDescription(model.getDescription());

		_roleRepository.save(role);
	}

	public RoleDto findById(String id) {
		RoleDto dto = new RoleDto();
		Role role = _roleRepository.findById(id);
		dto.setId(role.getId());
		dto.setName(role.getName());
		dto.setDescription(role.getDescription());
		return dto;
	}

	public void update(RoleDto model) {

		Role role = _roleRepository.findById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());

		_roleRepository.save(role);
	}

	public void delete(String id) {
		_roleRepository.delete(id);
	}

	public List<RoleDto> findNotAdmin() {
		// Khai báo danh sách RoleDTO trả về cho controller
		List<RoleDto> dtos = new ArrayList<RoleDto>();

		// Lấy danh sách Role từ tầng Repository
		List<Role> roles = this._roleRepository.findNotAdmin();

		// Lặp danh sách Role
		for (Role role : roles) {
			RoleDto dto = new RoleDto();

			dto.setId(role.getId());
			dto.setName(role.getName());
			dto.setDescription(role.getDescription());

			dtos.add(dto); // Thêm vào danh sách RoleDTO
		}
		return dtos; // Trả danh sách RoleDTO về cho COntroller
	}

}

package com.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.entity.Role;
import com.myproject.repository.IRoleRepository;
import com.myproject.service.IRoleService;
@Service
public class RoleServicesImpl implements IRoleService {

	@Autowired
	private IRoleRepository _rolIRoleRepository;

	@Override
	public List<Role> findAll() {
		return _rolIRoleRepository.findAll();
	}

	@Override
	public Role findById(String id) {
		return _rolIRoleRepository.findById(id).get();
	}

	@Override
	public boolean insert(Role model) {
		if (_rolIRoleRepository.findByName(model.getName()) != null) {
			return false;
		}
		_rolIRoleRepository.save(model);
		return true;
	}

	@Override
	public boolean update(Role model) {
		if (_rolIRoleRepository.findById(model.getId()) != null) {
			return false; // Prevent duplicate
		}

		if (_rolIRoleRepository.save(model) == null) { // Update failed
			return false;
		}

		return true;
	}

	@Override
	public void delete(String id) {
		_rolIRoleRepository.deleteById(id);
	}

}

package com.myproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.common.BaseRequestResponse;
import com.myproject.dto.RoleDto;
import com.myproject.entity.Role;
import com.myproject.repository.RoleRepository;
import com.myproject.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<RoleDto> findAll() {
		// Khai báo danh sách RoleDTO trả về cho controller
		List<RoleDto> dtos = new ArrayList<RoleDto>();

		// Lấy danh sách Role từ tầng Repository
		List<Role> roles = this.roleRepository.findAll();

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

	@Override
	public RoleDto findById(String id) {
		RoleDto dto = new RoleDto();
		Role role = roleRepository.findById(id).get();
		dto.setId(role.getId());
		dto.setName(role.getName());
		dto.setDescription(role.getDescription());
		return dto;
	}

	@Override
	public BaseRequestResponse<Null> insert(RoleDto model) {
		try {
			if(roleRepository.findByName(model.getName()) != null) {
				return new BaseRequestResponse<Null>(false, "Tên này đã được sử dụng!");
			}
			Role role = new Role();
			role.setId(UUID.randomUUID().toString());
			role.setName(model.getName());
			role.setDescription(model.getDescription());
			
			if(roleRepository.save(role) != null) {
				return new BaseRequestResponse<Null>(true, "Thêm mới thành công!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new BaseRequestResponse<Null>(false, "Thêm mới thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> update(RoleDto model) {
		try {
			Role role = roleRepository.findById(model.getId()).get();
			if(role == null) {
				return new BaseRequestResponse<Null>(false, "Không tìm thấy dữ liệu!");
			}
			role.setId(UUID.randomUUID().toString());
			role.setName(model.getName());
			role.setDescription(model.getDescription());
			
			if(roleRepository.save(role) != null) {
				return new BaseRequestResponse<Null>(true, "Cập nhật thành công!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new BaseRequestResponse<Null>(false, "Cập nhật thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> delete(String id) {
		try {
			roleRepository.deleteById(id);
			return new BaseRequestResponse<Null>(true, "Xóa quyền thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Xóa quyền thất bại!");
	}
}

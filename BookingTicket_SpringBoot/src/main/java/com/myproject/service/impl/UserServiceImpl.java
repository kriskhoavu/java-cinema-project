package com.myproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Null;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.common.BaseRequestResponse;
import com.myproject.dto.RegisterDto;
import com.myproject.dto.RoleDto;
import com.myproject.dto.UserDto;
import com.myproject.entity.Role;
import com.myproject.entity.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDto> findAll() {
		List<UserDto> userDtos = new ArrayList<UserDto>();
		List<User> users = userRepository.findAll();
		for(User item : users) {
			UserDto userDto = new UserDto();
			userDto.setId(item.getId());
			userDto.setEmail(item.getEmail());
			userDto.setFullname(item.getFullname());
			userDto.setAvatar(item.getAvatar());
			userDto.setPhone(item.getPhone());
			userDto.setAddress(item.getAddress());
			userDtos.add(userDto);
		}
		return userDtos;
	}

	@Override
	public UserDto findById(String id) {
		UserDto userDto = new UserDto();
		User user = userRepository.findById(id).get();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFullname(user.getFullname());
		userDto.setAvatar(user.getAvatar());
		userDto.setPhone(user.getPhone());
		userDto.setAddress(user.getAddress());
		userDto.setRoleId(user.getRoleId());
		
		Role role = user.getRole();
		userDto.setRole(new RoleDto(role.getId(), role.getName(), role.getDescription()));
		
		return userDto;
	}

	@Override
	public BaseRequestResponse<Null> insert(RegisterDto model) {
		
		if(userRepository.findByEmail(model.getEmail()) != null){
			return new BaseRequestResponse<Null>(false, "Email đã tồn tại!");
		}
		try {
			User user = new User();
			//Ramdom id
			user.setId(UUID.randomUUID().toString());
			user.setEmail(model.getEmail());
			// Hash password
			user.setPassword(BCrypt.hashpw(model.getPassword(), BCrypt.gensalt(12)));
			user.setFullname(model.getFullname());
			user.setAvatar(model.getAvatar());
			user.setPhone(model.getPhone());
			user.setAddress(model.getAddress());
			user.setRoleId(model.getRoleId());
			if(userRepository.save(user) != null) {
				return new BaseRequestResponse<Null>(true, "Thêm mới thành viên thành công!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Thêm mới thành viên thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> update(UserDto model) {
		try {
			User user = userRepository.findById(model.getId()).get();
			if(user == null){
				return new BaseRequestResponse<Null>(false, "Không tìm thấy thông tin!");
			}
			user.setEmail(model.getEmail());
			user.setFullname(model.getFullname());
			user.setAvatar(model.getAvatar());
			user.setPhone(model.getPhone());
			user.setAddress(model.getAddress());
			user.setRoleId(model.getRoleId());
			if(userRepository.save(user) != null) {
				return new BaseRequestResponse<Null>(true, "Cập nhật thành viên thành công!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Cập nhật thành viên thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> delete(String id) {
		try {
			userRepository.deleteById(id);
			return new BaseRequestResponse<Null>(true, "Xóa thành viên thất bại!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Xóa thành viên thất bại!");
	}
}

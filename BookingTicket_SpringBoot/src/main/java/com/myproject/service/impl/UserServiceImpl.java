package com.myproject.service.impl;

import com.myproject.entity.Role;
import com.myproject.entity.User;
import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.dto.RegisterDto;
import com.myproject.model.dto.RoleDto;
import com.myproject.model.dto.UserDto;
import com.myproject.repository.UserRepository;
import com.myproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll().stream().map(this::toUser).collect(Collectors.toList());
	}

	@Override
	public UserDto findById(String id) {
		return userRepository.findById(id).map(this::toUser).orElse(null);
	}

	@Override
	public ResponseModel<Null> insert(RegisterDto model) {

		if (userRepository.findByEmail(model.getEmail()) != null) {
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, "EMAIL ALREADY EXISTS");
		}
		try {
			User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setEmail(model.getEmail());
			user.setPhone(model.getPhone());
			user.setRoleId(model.getRoleId());
			user.setAvatar(model.getAvatar());
			user.setAddress(model.getAddress());
			user.setFullname(model.getFullname());
			user.setPassword(BCrypt.hashpw(model.getPassword(), BCrypt.gensalt(12)));
			userRepository.save(user);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> update(UserDto model) {
		try {
			return userRepository.findById(model.getId()).map(data -> {
				User user = new User();
				user.setEmail(data.getEmail());
				user.setFullname(data.getFullname());
				user.setAvatar(data.getAvatar());
				user.setPhone(data.getPhone());
				user.setAddress(data.getAddress());
				user.setRoleId(data.getRoleId());
				userRepository.save(user);
				return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
			}).orElse(new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND));

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> delete(String id) {
		try {
			userRepository.deleteById(id);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	private UserDto toUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFullname(user.getFullname());
		userDto.setAvatar(user.getAvatar());
		userDto.setPhone(user.getPhone());
		userDto.setAddress(user.getAddress());

		Role role = user.getRole();
		userDto.setRoleId(user.getRoleId());
		userDto.setRole(new RoleDto(role.getId(), role.getName(), role.getDescription()));
		return userDto;
	}

}

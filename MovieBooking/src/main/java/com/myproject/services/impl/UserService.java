package com.myproject.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dto.RegisterDto;
import com.myproject.dto.UserDto;
import com.myproject.entity.User;
import com.myproject.repository.UserRepository;
import com.myproject.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDto> findAll() {
		List<UserDto> userDtos = new ArrayList<UserDto>();
		List<User> users = userRepository.findAll();
		for (User item : users) {
			UserDto userDto = new UserDto();
			userDto.setId(item.getId());
			userDto.setEmail(item.getEmail());
			userDto.setFullname(item.getFullname());
			userDto.setAvatar(item.getAvatar());
			userDto.setPhone(item.getPhone());
			userDto.setAddress(item.getAddress());
			userDto.setWebsite(item.getWebsite());
			userDto.setFacebook(item.getFacebook());
			userDtos.add(userDto);
		}
		return userDtos;
	}

	public boolean save(RegisterDto model) {
		try {
			User user = new User();
			// Ramdom id
			user.setId(UUID.randomUUID().toString());
			user.setEmail(model.getEmail());
			// Hash password
			user.setPassword(BCrypt.hashpw(model.getPassword(), BCrypt.gensalt(12)));
			user.setFullname(model.getFullname());
			user.setAvatar(model.getAvatar());
			user.setPhone(model.getPhone());
			user.setAddress(model.getAddress());
			user.setWebsite(model.getWebsite());
			user.setFacebook(model.getFacebook());
			user.setRoleId(model.getRoleId());
			return userRepository.save(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public UserDto findById(String id) {
		UserDto userDto = new UserDto();
		User user = userRepository.findById(id);
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFullname(user.getFullname());
		userDto.setAvatar(user.getAvatar());
		userDto.setPhone(user.getPhone());
		userDto.setAddress(user.getAddress());
		userDto.setWebsite(user.getWebsite());
		userDto.setFacebook(user.getFacebook());
		userDto.setRoleId(user.getRoleId());
		return userDto;
	}

	public boolean update(UserDto model) {
		try {
			User user = userRepository.findById(model.getId());
			user.setEmail(model.getEmail());
			user.setFullname(model.getFullname());
			user.setAvatar(model.getAvatar());
			user.setPhone(model.getPhone());
			user.setAddress(model.getAddress());
			user.setWebsite(model.getWebsite());
			user.setFacebook(model.getFacebook());
			user.setRoleId(model.getRoleId());
			return userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String id) {
		return userRepository.delete(id);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean updatePassword(UserDto model) {
		// TODO Auto-generated method stub
		return false;
	}

}

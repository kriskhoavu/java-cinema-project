package com.myproject.services;

import java.util.List;

import com.myproject.dto.RegisterDto;
import com.myproject.dto.UserDto;
import com.myproject.entity.User;

public interface IUserService {
	public List<UserDto> findAll();

	public UserDto findById(String id);

	public boolean save(RegisterDto model);

	public boolean update(UserDto model);

	public boolean delete(String id);

	public User findByEmail(String email);
	
	public boolean updatePassword(UserDto model);
}

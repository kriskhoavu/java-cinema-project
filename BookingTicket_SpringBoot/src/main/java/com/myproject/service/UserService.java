package com.myproject.service;

import java.util.List;

import com.myproject.model.common.BaseRequestResponse;
import com.myproject.dto.RegisterDto;
import com.myproject.dto.UserDto;
import javax.validation.constraints.Null;

public interface UserService {
	public List<UserDto> findAll();
	public UserDto findById(String id);
	public BaseRequestResponse<Null> insert(RegisterDto model);
	public BaseRequestResponse<Null> update(UserDto model);
	public BaseRequestResponse<Null> delete(String id);
}

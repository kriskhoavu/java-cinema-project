package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.dto.RegisterDto;
import com.myproject.model.dto.UserDto;

import javax.validation.constraints.Null;
import java.util.List;

public interface UserService {
	List<UserDto> findAll();

	UserDto findById(String id);

	ResponseModel<Null> insert(RegisterDto model);

	ResponseModel<Null> update(UserDto model);

	ResponseModel<Null> delete(String id);
}

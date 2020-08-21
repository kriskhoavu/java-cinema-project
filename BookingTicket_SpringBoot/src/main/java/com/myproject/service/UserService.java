package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.dto.RegisterDto;
import com.myproject.model.dto.UserDto;

import javax.validation.constraints.Null;
import java.util.List;

public interface UserService {
    public List<UserDto> findAll();

    public UserDto findById(String id);

    public ResponseModel<Null> insert(RegisterDto model);

    public ResponseModel<Null> update(UserDto model);

    public ResponseModel<Null> delete(String id);
}

package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.dto.RoleDto;

import javax.validation.constraints.Null;
import java.util.List;

public interface RoleService {
	List<RoleDto> findAll();

	RoleDto findById(String id);

	ResponseModel<Null> insert(RoleDto model);

	ResponseModel<Null> update(RoleDto model);

	ResponseModel<Null> delete(String id);
}

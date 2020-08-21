package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.dto.RoleDto;

import javax.validation.constraints.Null;
import java.util.List;

public interface RoleService {
	public List<RoleDto> findAll();
	public RoleDto findById(String id);
	public ResponseModel<Null> insert(RoleDto model);
	public ResponseModel<Null> update(RoleDto model);
	public ResponseModel<Null> delete(String id);
}

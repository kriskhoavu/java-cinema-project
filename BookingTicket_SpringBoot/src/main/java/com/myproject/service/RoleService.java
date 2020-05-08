package com.myproject.service;

import java.util.List;

import com.myproject.common.BaseRequestResponse;
import com.myproject.dto.RoleDto;
import javax.validation.constraints.Null;

public interface RoleService {
	public List<RoleDto> findAll();
	public RoleDto findById(String id);
	public BaseRequestResponse<Null> insert(RoleDto model);
	public BaseRequestResponse<Null> update(RoleDto model);
	public BaseRequestResponse<Null> delete(String id);
}

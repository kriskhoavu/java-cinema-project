package com.myproject.service;

import java.util.List;

import com.myproject.model.common.BaseRequestResponse;
import com.myproject.entity.SeatCategory;
import javax.validation.constraints.Null;

public interface SeatCategoryService {
	public List<SeatCategory> findAll();
	public SeatCategory findById(int id);
	public BaseRequestResponse<Null> insert(SeatCategory model);
	public BaseRequestResponse<Null> update(SeatCategory model);
	public BaseRequestResponse<Null> delete(int id);
}

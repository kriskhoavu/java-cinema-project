package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.SeatCategory;

import javax.validation.constraints.Null;
import java.util.List;

public interface SeatCategoryService {
	List<SeatCategory> findAll();

	SeatCategory findById(int id);

	ResponseModel<Null> insert(SeatCategory model);

	ResponseModel<Null> update(SeatCategory model);

	ResponseModel<Null> delete(int id);
}

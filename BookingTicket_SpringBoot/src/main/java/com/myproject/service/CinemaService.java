package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cinema;

import javax.validation.constraints.Null;
import java.util.List;

public interface CinemaService {
	ResponseModel<List<Cinema>> findAll();

	ResponseModel<Cinema> findById(int id);

	ResponseModel<Null> insert(Cinema model);

	ResponseModel<Null> update(Cinema model);

	ResponseModel<Null> delete(int id);
}

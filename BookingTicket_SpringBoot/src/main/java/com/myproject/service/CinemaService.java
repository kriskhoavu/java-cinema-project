package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cinema;

import javax.validation.constraints.Null;
import java.util.List;

public interface CinemaService {
	public ResponseModel<List<Cinema>> findAll();
	public ResponseModel<Cinema> findById(int id);
	public ResponseModel<Null> insert(Cinema model);
	public ResponseModel<Null> update(Cinema model);
	public ResponseModel<Null> delete(int id);
}

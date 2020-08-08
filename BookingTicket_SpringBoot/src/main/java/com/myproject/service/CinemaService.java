package com.myproject.service;

import java.util.List;
import javax.validation.constraints.Null;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cinema;

public interface CinemaService {
	public List<Cinema> findAll();
	public Cinema findById(int id);
	public ResponseModel<Null> insert(Cinema model);
	public ResponseModel<Null> update(Cinema model);
	public ResponseModel<Null> delete(int id);
}

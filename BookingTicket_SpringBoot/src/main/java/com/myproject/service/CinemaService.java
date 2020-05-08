package com.myproject.service;

import java.util.List;
import javax.validation.constraints.Null;
import com.myproject.common.BaseRequestResponse;
import com.myproject.entity.Cinema;

public interface CinemaService {
	public List<Cinema> findAll();
	public Cinema findById(int id);
	public BaseRequestResponse<Null> insert(Cinema model);
	public BaseRequestResponse<Null> update(Cinema model);
	public BaseRequestResponse<Null> delete(int id);
}

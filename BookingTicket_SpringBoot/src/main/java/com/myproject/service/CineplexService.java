package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cineplex;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Null;
import java.util.List;

public interface CineplexService {
	public List<Cineplex> findAll();
	public Page<Cineplex> findAllPaging(int pageIndex, int pageSize);
	public Cineplex findById(int id);
	public ResponseModel<Null> insert(Cineplex model);
	public ResponseModel<Null> update(Cineplex model);
	public ResponseModel<Null> delete(int id);
}

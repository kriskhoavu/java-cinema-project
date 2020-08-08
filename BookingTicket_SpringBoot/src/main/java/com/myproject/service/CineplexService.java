package com.myproject.service;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.data.domain.Page;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cineplex;

public interface CineplexService {
	public List<Cineplex> findAll();
	public Page<Cineplex> findAllPaging(int pageIndex, int pageSize);
	public Cineplex findById(int id);
	public ResponseModel<Null> insert(Cineplex model);
	public ResponseModel<Null> update(Cineplex model);
	public ResponseModel<Null> delete(int id);
}

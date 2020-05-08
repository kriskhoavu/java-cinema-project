package com.myproject.service;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.data.domain.Page;

import com.myproject.common.BaseRequestResponse;
import com.myproject.entity.Cineplex;

public interface CineplexService {
	public List<Cineplex> findAll();
	public Page<Cineplex> findAllPaging(int pageIndex, int pageSize);
	public Cineplex findById(int id);
	public BaseRequestResponse<Null> insert(Cineplex model);
	public BaseRequestResponse<Null> update(Cineplex model);
	public BaseRequestResponse<Null> delete(int id);
}

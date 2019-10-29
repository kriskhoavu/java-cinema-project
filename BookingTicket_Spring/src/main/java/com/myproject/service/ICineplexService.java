package com.myproject.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.myproject.common.BaseResponse;
import com.myproject.entity.Cineplex;

public interface ICineplexService {
	List<Cineplex> findAll();

	Page<Cineplex> findAllPaging(int pageIdx, int pageSize);

	Cineplex findById(int id);

	BaseResponse insert(Cineplex model);

	BaseResponse update(Cineplex model);

	BaseResponse delete(int id);
}

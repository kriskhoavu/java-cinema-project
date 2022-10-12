package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cineplex;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Null;
import java.util.List;

public interface CineplexService {
	List<Cineplex> findAll();

	Page<Cineplex> findAllPaging(int pageIndex, int pageSize);

	Cineplex findById(int id);

	ResponseModel<Null> insert(Cineplex model);

	ResponseModel<Null> update(Cineplex model);

	ResponseModel<Null> delete(int id);
}

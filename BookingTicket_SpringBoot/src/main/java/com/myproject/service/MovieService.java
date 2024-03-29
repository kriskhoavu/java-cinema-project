package com.myproject.service;

import com.myproject.entity.Movie;
import com.myproject.model.common.ResponseModel;

import javax.validation.constraints.Null;
import java.util.List;

public interface MovieService {
	List<Movie> findAll();

	Movie findById(int id);

	ResponseModel<Null> insert(Movie model);

	ResponseModel<Null> update(Movie model);

	ResponseModel<Null> delete(int id);

	List<Movie> findMoviePlaying(boolean isPlaying);
}

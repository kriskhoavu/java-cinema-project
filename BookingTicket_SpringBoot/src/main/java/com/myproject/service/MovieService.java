package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Movie;

import javax.validation.constraints.Null;
import java.util.List;

public interface MovieService {
	public List<Movie> findAll();
	public Movie findById(int id);
	public ResponseModel<Null> insert(Movie model);
	public ResponseModel<Null> update(Movie model);
	public ResponseModel<Null> delete(int id);
	public List<Movie> findMoviePlaying(boolean isPlaying);
}

package com.myproject.service;

import java.util.List;

import com.myproject.common.BaseRequestResponse;
import com.myproject.entity.Movie;
import javax.validation.constraints.Null;

public interface MovieService {
	public List<Movie> findAll();
	public Movie findById(int id);
	public BaseRequestResponse<Null> insert(Movie model);
	public BaseRequestResponse<Null> update(Movie model);
	public BaseRequestResponse<Null> delete(int id);
	public List<Movie> findMoviePlaying(boolean isPlaying);
}

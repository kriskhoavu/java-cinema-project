package com.myproject.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.myproject.common.BaseResponse;
import com.myproject.entity.Movie;

public interface IMovieService {
	List<Movie> findAll();

	Page<Movie> findAllPaging(int pageIdx, int pageSize);

	Movie findById(int id);

	BaseResponse insert(Movie model);

	BaseResponse update(Movie model);

	BaseResponse delete(int id);

	List<Movie> findIsPlaying(boolean isPlaying);
}

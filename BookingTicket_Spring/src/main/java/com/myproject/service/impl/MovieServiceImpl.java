package com.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.myproject.common.BaseResponse;
import com.myproject.entity.Movie;
import com.myproject.repository.IMovieRepository;
import com.myproject.service.IMovieService;

@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private IMovieRepository _movieRepository;

	@Override
	public List<Movie> findAll() {
		return _movieRepository.findAll();
	}

	@Override
	public Page<Movie> findAllPaging(int pageIdx, int pageSize) {
		return null;
	}

	@Override
	public Movie findById(int id) {
		return null;
	}

	@Override
	public BaseResponse insert(Movie model) {
		return null;
	}

	@Override
	public BaseResponse update(Movie model) {
		return null;
	}

	@Override
	public BaseResponse delete(int id) {
		return null;
	}

	@Override
	public List<Movie> findIsPlaying(boolean isPlaying) {
		return _movieRepository.findByIsPlaying(isPlaying);
	}

}

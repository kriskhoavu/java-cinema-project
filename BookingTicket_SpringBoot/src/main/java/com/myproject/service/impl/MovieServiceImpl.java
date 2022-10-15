package com.myproject.service.impl;

import com.myproject.entity.Movie;
import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.repository.MovieRepository;
import com.myproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findById(int id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public ResponseModel<Null> insert(Movie model) {
		try {
			movieRepository.save(model);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> update(Movie model) {
		try {
			movieRepository.findById(model.getId()).ifPresent(movieRepository::save);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> delete(int id) {
		try {
			movieRepository.findById(id).ifPresent(move -> movieRepository.deleteById(move.getId()));
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public List<Movie> findMoviePlaying(boolean isPlaying) {
		return movieRepository.findMoviePlaying(isPlaying);
	}
}

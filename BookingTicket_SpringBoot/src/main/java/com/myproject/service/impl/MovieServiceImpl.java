package com.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.constraints.Null;

import com.myproject.common.BaseRequestResponse;
import com.myproject.entity.Movie;
import com.myproject.repository.MovieRepository;
import com.myproject.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findById(int id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public BaseRequestResponse<Null> insert(Movie model) {
		try {
			movieRepository.save(model);
			return new BaseRequestResponse<Null>(true, "Thêm mới thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Thêm mới thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> update(Movie model) {
		try {
			if(movieRepository.findById(model.getId()) == null) {
				return new BaseRequestResponse<Null>(false, "Không tìm thấy dữ liệu phù hợp!");
			}
			movieRepository.save(model);
			return new BaseRequestResponse<Null>(true, "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Cập nhật thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> delete(int id) {
		try {
			movieRepository.deleteById(id);
			return new BaseRequestResponse<Null>(true, "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Xóa thất bại!");
	}

	@Override
	public List<Movie> findMoviePlaying(boolean isPlaying) {
		return movieRepository.findMoviePlaying(isPlaying);
	}
}

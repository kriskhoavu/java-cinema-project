package com.myproject.service.impl;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cinema;
import com.myproject.repository.CinemaRepository;
import com.myproject.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {
	@Autowired
	private CinemaRepository cinemaRepository;

	@Override
	public List<Cinema> findAll() {
		return cinemaRepository.findAll();
	}

	@Override
	public Cinema findById(int id) {
		return cinemaRepository.findById(id).get();
	}

	@Override
	public ResponseModel<Null> insert(Cinema model) {
		try {
			cinemaRepository.save(model);
			return new ResponseModel<Null>(true, "Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseModel<Null>(false, "Failed");
	}

	@Override
	public ResponseModel<Null> update(Cinema model) {
		try {
			if (cinemaRepository.findById(model.getId()) == null) {
				return new ResponseModel<Null>(false, "Failed");
			}
			cinemaRepository.save(model);
			return new ResponseModel<Null>(true, "Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseModel<Null>(false, "Failed");
	}

	@Override
	public ResponseModel<Null> delete(int id) {
		try {
			cinemaRepository.deleteById(id);
			return new ResponseModel<Null>(true, "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseModel<Null>(false, "Xóa thất bại!");
	}
}

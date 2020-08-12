package com.myproject.service.impl;

import java.util.List;

import javax.validation.constraints.Null;

import com.myproject.model.common.CONSTANT;
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
	public ResponseModel<List<Cinema>> findAll() {
		List<Cinema> cinemaList = cinemaRepository.findAll();
		if(cinemaList.isEmpty()) {
			return new ResponseModel<List<Cinema>>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
		}

		return new ResponseModel<List<Cinema>>(
			CONSTANT.API_RESPONSE_STATUS_CODE_OK,
			CONSTANT.API_RESPONSE_STATUS_DESC_OK,
			cinemaList
		);
	}

	@Override
	public ResponseModel<Cinema> findById(int id) {
		Cinema cinema = cinemaRepository.findById(id).get();

		if(cinema.equals(null)) {
			return new ResponseModel<Cinema>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
		}

		return new ResponseModel<Cinema>(
			CONSTANT.API_RESPONSE_STATUS_CODE_OK,
			CONSTANT.API_RESPONSE_STATUS_DESC_OK,
			cinema
		);
	}

	@Override
	public ResponseModel<Null> insert(Cinema model) {
		try {
			cinemaRepository.save(model);
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> update(Cinema model) {
		try {
			if (cinemaRepository.findById(model.getId()) == null) {
				return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
			}
			cinemaRepository.save(model);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
		return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
	}

	@Override
	public ResponseModel<Null> delete(int id) {
		try {
			cinemaRepository.deleteById(id);
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}
}

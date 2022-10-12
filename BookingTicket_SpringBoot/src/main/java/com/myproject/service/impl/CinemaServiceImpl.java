package com.myproject.service.impl;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cinema;
import com.myproject.repository.CinemaRepository;
import com.myproject.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
	private final CinemaRepository cinemaRepository;

	@Override
	public ResponseModel findAll() {
		List<Cinema> cinemaList = cinemaRepository.findAll();
		if (cinemaList.isEmpty()) {
			return new ResponseModel<List<Cinema>>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
		}

		return new ResponseModel<>(
			CONSTANT.API_RESPONSE_STATUS_CODE_OK,
			CONSTANT.API_RESPONSE_STATUS_DESC_OK,
			cinemaList
		);
	}

	@Override
	public ResponseModel findById(int id) {
		return cinemaRepository.findById(id).map(cinema -> new ResponseModel<>(
			CONSTANT.API_RESPONSE_STATUS_CODE_OK,
			CONSTANT.API_RESPONSE_STATUS_DESC_OK,
			cinema
		)).orElse(null);

	}

	@Override
	public ResponseModel<Null> insert(Cinema model) {
		try {
			cinemaRepository.save(model);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> update(Cinema model) {
		try {
			cinemaRepository.findById(model.getId()).ifPresent(cinemaRepository::save);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
		return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
	}

	@Override
	public ResponseModel<Null> delete(int id) {
		try {
			cinemaRepository.deleteById(id);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}
}

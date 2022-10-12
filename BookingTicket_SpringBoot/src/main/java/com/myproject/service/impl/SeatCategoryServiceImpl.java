package com.myproject.service.impl;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.SeatCategory;
import com.myproject.repository.SeatCategoryRepository;
import com.myproject.service.SeatCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatCategoryServiceImpl implements SeatCategoryService {
	private final SeatCategoryRepository seatCategoryRepository;

	@Override
	public List<SeatCategory> findAll() {
		return seatCategoryRepository.findAll();
	}

	@Override
	public SeatCategory findById(int id) {
		return seatCategoryRepository.findById(id).orElse(null);
	}

	@Override
	public ResponseModel<Null> insert(SeatCategory model) {
		try {
			if (seatCategoryRepository.findByName(model.getName()) != null) {
				return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, "SEAT ALREADY RESERVED");
			}
			seatCategoryRepository.save(model);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> update(SeatCategory model) {
		try {
			seatCategoryRepository.findById(model.getId()).ifPresent(seatCategoryRepository::save);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> delete(int id) {
		try {
			seatCategoryRepository.deleteById(id);
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}
}

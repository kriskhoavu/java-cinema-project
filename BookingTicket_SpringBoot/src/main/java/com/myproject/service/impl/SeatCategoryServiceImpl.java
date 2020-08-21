package com.myproject.service.impl;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.SeatCategory;
import com.myproject.repository.SeatCategoryRepository;
import com.myproject.service.SeatCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class SeatCategoryServiceImpl implements SeatCategoryService{
	@Autowired
	private SeatCategoryRepository seatCategoryRepository;
	
	@Override
	public List<SeatCategory> findAll() {
		return seatCategoryRepository.findAll();
	}

	@Override
	public SeatCategory findById(int id) {
		return seatCategoryRepository.findById(id).get();
	}

	@Override
	public ResponseModel<Null> insert(SeatCategory model) {
		try {
			if(seatCategoryRepository.findByName(model.getName()) != null) {
				return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, "SEAT ALREADY RESERVED");
			}
			seatCategoryRepository.save(model);

			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> update(SeatCategory model) {
		try {
			if(seatCategoryRepository.findById(model.getId()) == null) {
				return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
			}
			seatCategoryRepository.save(model);
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> delete(int id) {
		try {
			seatCategoryRepository.deleteById(id);
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}
}

package com.myproject.service.impl;

import java.util.List;

import javax.validation.constraints.Null;

import com.myproject.model.common.CONSTANT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cineplex;
import com.myproject.repository.CineplexRepository;
import com.myproject.service.CineplexService;

@SuppressWarnings("deprecation")
@Service
public class CineplexServiceImpl implements CineplexService {
	@Autowired
	private CineplexRepository _cineplexRepository;

	@Override
	public List<Cineplex> findAll() {
		return _cineplexRepository.findAll();
	}

	@Override
	public Cineplex findById(int id) {
		return _cineplexRepository.findById(id).get();
	}

	@Override
	public ResponseModel<Null> insert(Cineplex model) {
		try {
			_cineplexRepository.save(model);
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> update(Cineplex model) {
		try {
			if (_cineplexRepository.findById(model.getId()) == null) {
				return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
			}
			_cineplexRepository.save(model);
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public ResponseModel<Null> delete(int id) {
		try {
			_cineplexRepository.deleteById(id);
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
		}
	}

	@Override
	public Page<Cineplex> findAllPaging(int pageIndex, int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		return _cineplexRepository.findAllPaging(pageable);
	}
}

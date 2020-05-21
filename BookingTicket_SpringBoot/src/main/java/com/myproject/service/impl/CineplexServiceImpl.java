package com.myproject.service.impl;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myproject.model.common.BaseRequestResponse;
import com.myproject.entity.Cineplex;
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
	public BaseRequestResponse<Null> insert(Cineplex model) {
		try {
			_cineplexRepository.save(model);
			return new BaseRequestResponse<Null>(true, "Thêm mới thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Thêm mới thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> update(Cineplex model) {
		try {
			if (_cineplexRepository.findById(model.getId()) == null) {
				return new BaseRequestResponse<Null>(false, "Không tìm thấy dữ liệu phù hợp!");
			}
			_cineplexRepository.save(model);
			return new BaseRequestResponse<Null>(true, "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Cập nhật thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> delete(int id) {
		try {
			_cineplexRepository.deleteById(id);
			return new BaseRequestResponse<Null>(true, "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Xóa thất bại!");
	}

	@Override
	public Page<Cineplex> findAllPaging(int pageIndex, int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		return _cineplexRepository.findAllPaging(pageable);
	}
}

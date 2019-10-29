package com.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myproject.common.BaseResponse;
import com.myproject.entity.Cineplex;
import com.myproject.repository.ICineplexRepository;
import com.myproject.service.ICineplexService;

@Service
public class CineplexServiceImpl implements ICineplexService {

	@Autowired
	private ICineplexRepository _cineplexRepository;

	@Override
	public List<Cineplex> findAll() {
		return _cineplexRepository.findAll();
	}

	@Override
	public Cineplex findById(int id) {
		return _cineplexRepository.findById(id).get();
	}

	@Override
	public BaseResponse insert(Cineplex model) {
		try {
			_cineplexRepository.save(model);
			return new BaseResponse(true, "Thêm mới thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseResponse(false, "Thêm mới thất bại!");
	}

	@Override
	public BaseResponse update(Cineplex model) {
		try {
			if (_cineplexRepository.findById(model.getId()) == null) {
				return new BaseResponse(false, "Không tìm thấy dữ liệu phù hợp!");
			}
			_cineplexRepository.save(model);
			return new BaseResponse(true, "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseResponse(false, "Cập nhật thất bại!");
	}

	@Override
	public BaseResponse delete(int id) {
		try {
			System.out.println(id);
			_cineplexRepository.deleteById(id);
			return new BaseResponse(true, "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseResponse(false, "Xóa thất bại!");
	}

	@Override
	public Page<Cineplex> findAllPaging(int pageIdx, int pageSize) {
		Pageable pageable = new PageRequest(pageIdx, pageSize);
		return _cineplexRepository.findAllPaging(pageable);
	}
}

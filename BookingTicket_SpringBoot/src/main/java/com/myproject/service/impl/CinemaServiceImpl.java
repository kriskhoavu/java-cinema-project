package com.myproject.service.impl;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.common.BaseRequestResponse;
import com.myproject.entity.Cinema;
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
	public BaseRequestResponse<Null> insert(Cinema model) {
		try {
			cinemaRepository.save(model);
			return new BaseRequestResponse<Null>(true, "Thêm mới thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Thêm mới thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> update(Cinema model) {
		try {
			if (cinemaRepository.findById(model.getId()) == null) {
				return new BaseRequestResponse<Null>(false, "Không tìm thấy dữ liệu phù hợp!");
			}
			cinemaRepository.save(model);
			return new BaseRequestResponse<Null>(true, "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Cập nhật thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> delete(int id) {
		try {
			cinemaRepository.deleteById(id);
			return new BaseRequestResponse<Null>(true, "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Xóa thất bại!");
	}
}

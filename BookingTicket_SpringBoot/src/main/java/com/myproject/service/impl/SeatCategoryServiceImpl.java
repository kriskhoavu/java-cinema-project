package com.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.constraints.Null;
import com.myproject.model.common.BaseRequestResponse;
import com.myproject.entity.SeatCategory;
import com.myproject.repository.SeatCategoryRepository;
import com.myproject.service.SeatCategoryService;

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
	public BaseRequestResponse<Null> insert(SeatCategory model) {
		try {
			if(seatCategoryRepository.findByName(model.getName()) != null) {
				return new BaseRequestResponse<Null>(false, "Tên này đã được sử dụng!");
			}
			seatCategoryRepository.save(model);
			return new BaseRequestResponse<Null>(true, "Thêm mới thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Thêm mới thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> update(SeatCategory model) {
		try {
			if(seatCategoryRepository.findById(model.getId()) == null) {
				return new BaseRequestResponse<Null>(false, "Không tìm thấy dữ liệu phù hợp!");
			}
			seatCategoryRepository.save(model);
			return new BaseRequestResponse<Null>(true, "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Cập nhật thất bại!");
	}

	@Override
	public BaseRequestResponse<Null> delete(int id) {
		try {
			seatCategoryRepository.deleteById(id);
			return new BaseRequestResponse<Null>(true, "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseRequestResponse<Null>(false, "Xóa thất bại!");
	}
}

package com.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.constraints.Null;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.SeatCategory;
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
	public ResponseModel<Null> insert(SeatCategory model) {
		try {
			if(seatCategoryRepository.findByName(model.getName()) != null) {
				return new ResponseModel<Null>(false, "Tên này đã được sử dụng!");
			}
			seatCategoryRepository.save(model);
			return new ResponseModel<Null>(true, "Thêm mới thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseModel<Null>(false, "Thêm mới thất bại!");
	}

	@Override
	public ResponseModel<Null> update(SeatCategory model) {
		try {
			if(seatCategoryRepository.findById(model.getId()) == null) {
				return new ResponseModel<Null>(false, "Không tìm thấy dữ liệu phù hợp!");
			}
			seatCategoryRepository.save(model);
			return new ResponseModel<Null>(true, "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseModel<Null>(false, "Cập nhật thất bại!");
	}

	@Override
	public ResponseModel<Null> delete(int id) {
		try {
			seatCategoryRepository.deleteById(id);
			return new ResponseModel<Null>(true, "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseModel<Null>(false, "Xóa thất bại!");
	}
}

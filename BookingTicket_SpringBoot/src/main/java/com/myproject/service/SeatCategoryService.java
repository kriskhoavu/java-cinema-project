package com.myproject.service;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.SeatCategory;

import javax.validation.constraints.Null;
import java.util.List;

public interface SeatCategoryService {
    public List<SeatCategory> findAll();

    public SeatCategory findById(int id);

    public ResponseModel<Null> insert(SeatCategory model);

    public ResponseModel<Null> update(SeatCategory model);

    public ResponseModel<Null> delete(int id);
}

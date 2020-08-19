package com.myproject.Util;

import com.myproject.model.common.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseUtil<T> {

    public ResponseEntity createResponse(HttpStatus httpStatus, ResponseModel<T> resModel) {
        return ResponseEntity.ok(resModel);
    }

}

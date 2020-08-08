package com.myproject.Util;

import com.myproject.model.common.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity createResponse(HttpStatus httpStatus, ResponseModel resModel) {
        resModel.setHttpStatus(httpStatus);

        return ResponseEntity.ok(resModel);
    }

}

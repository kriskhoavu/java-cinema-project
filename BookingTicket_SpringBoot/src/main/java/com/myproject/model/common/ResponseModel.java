package com.myproject.model.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseModel<T> {
	private T data;
	private String message;
	private boolean status;
	private HttpStatus httpStatus;

	public ResponseModel() {
	}

	public ResponseModel(boolean status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResponseModel(boolean status, String message, T data) {
		this.data = data;
		this.status = status;
		this.message = message;
	}
}

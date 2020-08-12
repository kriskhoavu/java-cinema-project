package com.myproject.model.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseModel<T> {
	private int statusCode;
	private String message;
	private T data;

	public ResponseModel() {
	}

	public ResponseModel(int status, String message) {
		this.statusCode = status;
		this.message = message;
	}

	public ResponseModel(int status, String message, T data) {
		this.data = data;
		this.statusCode = status;
		this.message = message;
	}
}

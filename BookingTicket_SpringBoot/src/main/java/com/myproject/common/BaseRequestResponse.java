package com.myproject.common;

import org.springframework.http.HttpStatus;

public class BaseRequestResponse<T> {
	
	private boolean status;
	private HttpStatus responseCode;
	private String message;
	private T data;

	public BaseRequestResponse() {}

	public BaseRequestResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public HttpStatus getResponseCode() {
		return this.responseCode;
	}	

	public String getMessage() {
		return this.message;
	}

	public T getData() {
		return this.data;
	}	

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(T data) {
		this.data = data;
	}
}

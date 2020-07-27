package com.pacom.swagger2.dto.response;

public class BaseResponse<T> {
	String status;
	T data;

	public BaseResponse() {
	}

	public BaseResponse(String status, T data) {
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

package com.pacom.swagger2.utis.enumerater;

public enum BodyResponseStatus implements CheckEnumerate<BodyResponseStatus>{
	SUCCESS("success"), ERROR("error");

	private String status;

	BodyResponseStatus(String status) {
		this.status = status;
	}

	public String getValue() {
		return status;
	}
}

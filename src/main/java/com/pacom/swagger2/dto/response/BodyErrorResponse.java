package com.pacom.swagger2.dto.response;

import com.pacom.swagger2.utis.enumerater.BodyResponseStatus;

public class BodyErrorResponse extends BaseResponse {
	public BodyErrorResponse() {
		setStatus(BodyResponseStatus.ERROR.getValue());
	}
}

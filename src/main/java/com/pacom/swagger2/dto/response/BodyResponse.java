package com.pacom.swagger2.dto.response;

import com.pacom.swagger2.utis.enumerater.BodyResponseStatus;

public class BodyResponse extends BaseResponse {
	public BodyResponse() {
		setStatus(BodyResponseStatus.SUCCESS.getValue());
	}
}

package com.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.client.RMClient;
import com.api.dto.api.RMRequest;
import com.api.service.InquireRmTrailerService;

@Component
public class InquireRmTrailerServiceImpl implements InquireRmTrailerService {

	@Autowired
	private RMClient rmClient;

	@Override
	public Object get(RMRequest rmRequest) {
		return rmClient.inqRMTrailers2();
	}

//	@Override
//	public RMResponse get(RMRequest rmRequest) {
//		return new RMResponse();
//	}

}

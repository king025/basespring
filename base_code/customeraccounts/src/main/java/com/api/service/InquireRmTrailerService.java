package com.api.service;

import org.springframework.stereotype.Service;

import com.api.dto.api.RMRequest;

@Service
public interface InquireRmTrailerService {
	
	Object get(RMRequest rmRequest);
	
//	RMResponse get(RMRequest rmRequest);

}

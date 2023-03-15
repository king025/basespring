package com.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.dto.api.RMRequest;
import com.api.dto.api.RMRequest.RMAcctNo;
import com.api.dto.api.RMRequest.RMCustomerCtrlNumber;
import com.api.service.InquireRmTrailerService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private InquireRmTrailerService inquireRmTrailerService;

	@Test
	void getTest() {
		RMRequest request = new RMRequest(
				new RMAcctNo(new RMCustomerCtrlNumber("0088", "0000", "0000", "0000"), "00000020751266", ""));
		Object obj = inquireRmTrailerService.get(request);
		Assertions.assertNotNull(obj);
	}

}

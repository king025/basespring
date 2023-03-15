package com.api.inquiries.rm;

import com.api.inquiries.rm.client.DataClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class RmApplicationTests {

	@Autowired
	private DataClient dataClient;

	@Test
	public void getAll(){
		Map<String, Object> data = dataClient.getAll();
		Assertions.assertNotNull(data);
	}
}

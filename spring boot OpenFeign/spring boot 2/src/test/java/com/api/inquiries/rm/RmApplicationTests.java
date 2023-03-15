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
	private DataClient dataService;

	@Test
	public void getData(){
		Map<String, Object> data = dataService.getData();
		Assertions.assertNotNull(data);
	}

}

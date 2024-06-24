package com.example.demo;

import com.example.demo.service.client.SampClient;
import com.example.demo.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.oorsprong.websamples.CountryName;
import org.oorsprong.websamples.CountryNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SampClient sampClient;

	private CountryNameResponse countryNameResponse = new CountryNameResponse();

	@Test
	void sampTest() throws Exception {
		when(sampClient.postCountryIso(any(CountryName.class))).thenReturn(countryNameResponse);
		String json = TestUtil.asJsonString(TestUtil.user1());
		RequestBuilder req = MockMvcRequestBuilders.post("/samp/soap")
				.servletPath("/samp/soap").content(json)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(req).andExpect(status().isOk()).andDo(print());
	}

}

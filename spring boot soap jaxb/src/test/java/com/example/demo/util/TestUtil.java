package com.example.demo.util;

import com.example.demo.dto.api.SampRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

	public static SampRequest user1() {
		return new SampRequest("12");
	}

	public static String asJsonString(final Object obj) {
		try{
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

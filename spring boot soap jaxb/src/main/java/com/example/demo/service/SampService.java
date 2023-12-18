package com.example.demo.service;

import com.example.demo.dto.api.SampRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SampService {
	ResponseEntity<Object> post(SampRequest sampRequest);
}

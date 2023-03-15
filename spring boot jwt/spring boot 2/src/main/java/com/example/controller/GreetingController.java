package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.crypto.SecretKey;

import com.example.model.UsersDAO;
import com.example.impl.GreetingImpl;

import org.apache.commons.codec.digest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.model.Greeting;

@RestController
public class GreetingController {

	@Value("${jwt.issuer}")
	private String issuer;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private GreetingImpl greet = new GreetingImpl();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/generateKey")
	public SecretKey generateKey() {
		try {
			return greet.getSecretKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/generateCipherKey/{encryption}")
	/*
	 * sample path 
	 * 	localhost:8080/generateCipherKey/AES
	 */
	public String generateCipherKey(@PathVariable String encryption) {
		try {
			return greet.getCipherKey(encryption);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/hash-this/{any}")
	public String hashThis(@PathVariable String any) {
		byte[] digest = new DigestUtils(MessageDigestAlgorithms.SHA_256).digest(any);
		return """
				{
					"Input String":%s,
					"Java Built-in hash": %o,
					"SHA-256" = %s
				}
				""".formatted(any, any.hashCode(), digest.toString());
	}

	@PostMapping(value = "/login",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> login(@RequestBody UsersDAO userDetails) {
		Map<String, Object> response = new HashMap<String, Object>();
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();
		try {
			response = greet.JWS_HS256(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
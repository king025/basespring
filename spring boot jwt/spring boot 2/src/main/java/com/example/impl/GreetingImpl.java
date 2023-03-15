package com.example.impl;

import com.example.service.GreetingService;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.*;
import org.jose4j.keys.HmacKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

@Service
public class GreetingImpl implements GreetingService {

	@Value("${jwt.issuer}")
	private String issuer;

	@Value("${jwt.subject}")
	private String subject;

	public SecretKey getSecretKey()
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		SecretKey key = kg.generateKey();
		return key;
	}
	
	public String getCipherKey(String encryption) 
			throws InvalidKeyException,NoSuchAlgorithmException, NoSuchPaddingException, 
			BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance(encryption);
		KeyGenerator kg = KeyGenerator.getInstance(encryption);
		//TODO add key-pair
		
		Key key = kg.generateKey();
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] cipherText = cipher.doFinal("test".getBytes());
		return cipherText.toString();
	}

	public String JWS_noAlg() throws Exception {
		JwtClaims jwtClaims = new JwtClaims();

		jwtClaims.setSubject(subject); // set sub
		jwtClaims.setIssuedAtToNow();  // set iat
		jwtClaims.setExpirationTimeMinutesInTheFuture(10080); // set exp
		jwtClaims.setIssuer(issuer); // set iss
		jwtClaims.setStringClaim("name", "Peter Bautista");   // set name
		jwtClaims.setStringClaim("email", "something@somewhere.com");//set email
		jwtClaims.setClaim("email_verified", true);  //set email_verified

		JsonWebSignature jws = new JsonWebSignature();
		jws.setAlgorithmConstraints(AlgorithmConstraints.NO_CONSTRAINTS);
		jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.NONE);
		jws.setPayload(jwtClaims.toJson());

		String jwt = jws.getCompactSerialization(); //produce eyJ.. JWT

		return jwt;
	}

	public Map<String, Object> JWS_consume(String jwt) throws Exception {
		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
				// required for NONE alg
				.setJwsAlgorithmConstraints(AlgorithmConstraints.NO_CONSTRAINTS)
				// disable signature requirement
				.setDisableRequireSignature()
				// require the JWT to have iat field
				.setRequireIssuedAt()
				// require the JWT to have exp field
				.setRequireExpirationTime()
				// expect the iss to be https://ntt-something.com
				.setExpectedIssuer(issuer)
				.build();

		// process JWT to jwt context
		JwtContext jwtContext = jwtConsumer.process(jwt);
		// get JWS object
		JsonWebSignature jws = (JsonWebSignature)jwtContext.getJoseObjects().get(0);
		// get claims
		JwtClaims jwtClaims = jwtContext.getJwtClaims();
		// print claims as map
		return jwtClaims.getClaimsMap();
	}


	public Map<String,Object> JWS_HS256(String name, String password) throws Exception {

		// generate  key
		byte[] key = new byte[32];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(key);
		HmacKey hmacKey = new HmacKey(key);

		JwtClaims jwtClaims = new JwtClaims();
		jwtClaims.setSubject(subject); // set sub
		jwtClaims.setIssuedAtToNow();  // set iat
		jwtClaims.setExpirationTimeMinutesInTheFuture(10080); // set exp
		jwtClaims.setIssuer(issuer); // set iss
		//jwtClaims.setIssuer(sec.getIssuer());
		jwtClaims.setStringClaim("name", name);   // set name
		jwtClaims.setStringClaim("password", password);//set password
		jwtClaims.setClaim("email_verified", true);  //set email_verified

		JsonWebSignature jws = new JsonWebSignature();
		// Set alg header as HMAC_SHA256
		jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
		// Set key to hmacKey
		jws.setKey(hmacKey);
		jws.setPayload(jwtClaims.toJson());
		// Generate JWT token
		String jwt = jws.getCompactSerialization(); //produce eyJ.. JWT

		/* Consume JWT Token */
		// we don't need NO_CONSTRAINT and disable require signature anymore
		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
				.setRequireIssuedAt()
				.setRequireExpirationTime()
				.setExpectedIssuer("https://ntt-something.com")
				// set the verification key
				.setVerificationKey(hmacKey)
				.build();

		// process JWT to jwt context
		JwtContext jwtContext = jwtConsumer.process(jwt);
		// get JWS object
		JsonWebSignature consumedJWS = (JsonWebSignature)jwtContext.getJoseObjects().get(0);
		// get claims
		JwtClaims consumedJWTClaims = jwtContext.getJwtClaims();

		// print claims as map
		return consumedJWTClaims.getClaimsMap();
	}

}

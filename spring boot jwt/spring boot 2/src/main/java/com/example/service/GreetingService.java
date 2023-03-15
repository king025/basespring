package com.example.service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

public interface GreetingService {
    public SecretKey getSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException;

    public String getCipherKey(String encryption) throws InvalidKeyException,NoSuchAlgorithmException, NoSuchPaddingException,
            BadPaddingException, IllegalBlockSizeException;

    public String JWS_noAlg() throws Exception;

    public Map<String, Object> JWS_consume(String jwt) throws Exception;

    public Map<String,Object> JWS_HS256(String username, String password) throws Exception;

}

package com.reviewer.services;

import com.reviewer.dto.UserDTO;
import com.reviewer.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    ResponseEntity<User> saveUser(UserDTO userDto);
    ResponseEntity<List<User>> findAllUsers();
    ResponseEntity<HttpStatus> deleteUserById(String id);
}

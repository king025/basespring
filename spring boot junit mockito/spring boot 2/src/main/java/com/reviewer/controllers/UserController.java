package com.reviewer.controllers;

import com.reviewer.dto.UserDTO;
import com.reviewer.model.User;
import com.reviewer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping()
    public ResponseEntity<List<User>> retrieveAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        return userService.deleteUserById(id);
    }

}

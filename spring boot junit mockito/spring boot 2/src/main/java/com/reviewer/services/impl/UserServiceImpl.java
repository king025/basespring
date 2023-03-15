package com.reviewer.services.impl;

import com.reviewer.dao.UserRepository;
import com.reviewer.dto.UserDTO;
import com.reviewer.handlers.RecordNotFoundException;
import com.reviewer.model.User;
import com.reviewer.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<User> saveUser(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        if (user.getId() == null) {
            return ResponseEntity.ok().body(userRepository.save(user));
        } else {
            Optional<User> userOptional = userRepository.findById(user.getId());
            if (userOptional.isPresent()) {
                User updatedUser = userOptional.get();
                updatedUser.setFirstName(user.getFirstName());
                updatedUser.setLastName(user.getLastName());
                return ResponseEntity.ok().body(userRepository.save(updatedUser));
            } else {
                return ResponseEntity.ok().body(userRepository.save(user));
            }
        }
    }

    @Override
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userRepository.findAll();
        if (!CollectionUtils.isEmpty(users)) {
            return ResponseEntity.ok().body(users);
        } else {
            throw new RecordNotFoundException("No user/s exist.");
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().body(HttpStatus.OK);
        } else {
            return ResponseEntity.ok().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.reviewer.services;

import com.reviewer.dto.UserDTO;
import com.reviewer.model.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    private static User user;
    private static UserDTO userDTO;
    private static UserDTO userDTO2;
    private static User user22;
    private static UserDTO userDTO22;

    @BeforeAll
    static void setup() {
        userDTO = new UserDTO();
        userDTO.setFirstName("RobertaXYZ");
        userDTO.setLastName("FranklinXYZ");

        ModelMapper modelMapper = new ModelMapper();
        user = modelMapper.map(userDTO, User.class);

        userDTO2 = new UserDTO();
        userDTO2.setId("abcde12345");
        userDTO2.setFirstName("RobertaXYZwithID");
        userDTO2.setLastName("FranklinXYZwithID");

        userDTO22 = new UserDTO();
        userDTO22.setId("abcde12345");
        userDTO22.setFirstName("RobertaXYZupdated");
        userDTO22.setLastName("FranklinXYZupdated");

        user22 = modelMapper.map(userDTO22, User.class);
    }

    @Test
    @Order(1)
    void createUserWithoutIdTest() {
        Assertions.assertNotNull(userService.saveUser(userDTO));
        Assertions.assertEquals("RobertaXYZ", Objects.requireNonNull(userService.saveUser(userDTO).getBody()).getFirstName());
        Assertions.assertEquals("FranklinXYZ", Objects.requireNonNull(userService.saveUser(userDTO).getBody()).getLastName());
    }

    @Test
    @Order(2)
    void createUserWithIdTest() {
        Assertions.assertNotNull(userService.saveUser(userDTO2));
        Assertions.assertEquals("abcde12345", Objects.requireNonNull(userService.saveUser(userDTO2).getBody()).getId());
        Assertions.assertEquals("RobertaXYZwithID", Objects.requireNonNull(userService.saveUser(userDTO2).getBody()).getFirstName());
        Assertions.assertEquals("FranklinXYZwithID", Objects.requireNonNull(userService.saveUser(userDTO2).getBody()).getLastName());
    }

    @Test
    @Order(3)
    void updateUserTest() {
        Assertions.assertNotNull(userService.saveUser(userDTO22));
        Assertions.assertEquals("abcde12345", Objects.requireNonNull(userService.saveUser(userDTO22).getBody()).getId());
        Assertions.assertEquals("RobertaXYZupdated", Objects.requireNonNull(userService.saveUser(userDTO22).getBody()).getFirstName());
        Assertions.assertEquals("FranklinXYZupdated", Objects.requireNonNull(userService.saveUser(userDTO22).getBody()).getLastName());
    }

    @Test
    @Order(4)
    void retrieveUsersTest() {
        Assertions.assertNotNull(userService.findAllUsers());
        Assertions.assertNotEquals(0, Objects.requireNonNull(userService.findAllUsers().getBody()).size());
    }

    @Test
    @Order(5)
    void deleteUpdatedUserTest() {
        Assertions.assertEquals(HttpStatus.OK, userService.deleteUserById(user22.getId()).getBody());
    }

    @Test
    @Order(6)
    void deleteCreatedUserTest() {
        ResponseEntity<List<User>> users = userService.findAllUsers();
        if (Objects.requireNonNull(users.getBody()).size() > 0) {
            for (User removeUser: users.getBody()) {
                if ("RobertaXYZ".equalsIgnoreCase(removeUser.getFirstName())
                        && "FranklinXYZ".equalsIgnoreCase(removeUser.getLastName())) {
                    userService.deleteUserById(removeUser.getId());
                }
            }
        }
        Assertions.assertFalse(users.getBody().contains(user));
    }

    @Test
    @Order(7)
    void deleteNonExistingUserTest() {
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, userService.deleteUserById("noSameId").getBody());
    }

}

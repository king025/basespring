package com.reviewer.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reviewer.dto.UserDTO;
import com.reviewer.model.User;
import com.reviewer.services.impl.UserServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    UserServiceImpl userService;

    @Autowired
    MockMvc mockMvc;

    private static User user1;
    private static User user2;
    private static User user3;
    private static UserDTO userDTO1;

    @BeforeAll
    static void setup() {
        userDTO1 = new UserDTO();
        userDTO1.setFirstName("Tara");
        userDTO1.setLastName("Farrell");

        ModelMapper modelMapper = new ModelMapper();
        user1 = modelMapper.map(userDTO1, User.class);

        user2 = new User("createSampleUser2", "Rodrick", "Pace");

        user3 = new User("createSampleUser2", "Robrick", "Face");
    }

    @Test
    void retrieveAllUsersTest() throws Exception {
        List<User> users = List.of(user1);

        when(userService.findAllUsers()).thenReturn(ResponseEntity.ok(users));

        mockMvc.perform(get("/v1/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Tara")))
                .andDo(print());
        verify(userService, atLeastOnce()).findAllUsers();
    }

    @Test
    void createUserTest() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final String jsonContent = mapper.writeValueAsString(user2);

        when(userService.saveUser(Mockito.any(UserDTO.class)))
                .thenReturn(ResponseEntity.ok(user2));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/user")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", Matchers.is("Rodrick")))
                .andDo(print());
        verify(userService, atLeastOnce()).saveUser(Mockito.any(UserDTO.class));
    }

    @Test
    void updateUserTest() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final String jsonContent = mapper.writeValueAsString(user3);

        when(userService.saveUser(Mockito.any(UserDTO.class)))
                .thenReturn(ResponseEntity.ok(user3));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/user")
                .content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", Matchers.is("Robrick")))
                .andDo(print());
        verify(userService, atLeastOnce()).saveUser(Mockito.any(UserDTO.class));
    }

    @Test
    void deleteUserTest() throws Exception {
        when(userService.deleteUserById(any(String.class)))
                .thenReturn(ResponseEntity.ok().body(HttpStatus.OK));

        mockMvc.perform(delete("/v1/user/{id}", "deleteSampleUser4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is("OK")))
                .andDo(print());
        verify(userService, atLeastOnce()).deleteUserById(any(String.class));
    }
}

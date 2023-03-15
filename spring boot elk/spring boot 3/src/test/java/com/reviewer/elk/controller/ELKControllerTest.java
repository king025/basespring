package com.reviewer.elk.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reviewer.elk.service.ELKService;
import com.reviewer.elk.service.RestService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ELKController.class)
public class ELKControllerTest {

    @MockBean
    ELKService elkService;

    @MockBean
    RestService restService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void displayHelloWorldTest() throws Exception {

        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk());
    }

    @Test
    public void getFoodDetails() throws Exception {
        JSONObject fruit1 = new JSONObject();
        fruit1.put("name", "apple");
        JSONArray json = new JSONArray();
        json.add(fruit1);
        Mockito.when(elkService.getAllFoodDetails()).thenReturn(json);
        mockMvc.perform(get("/api/Food-Details"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"name\":\"apple\"}]"));
    }

    @Test
    public void getWeatherInformationTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String weatherJson =
                "{ \"city\" : \"Manila\", \"temperature\" : \"27DC\" }";
        JsonNode node = mapper.readTree(weatherJson);
        Mockito.when(restService.getPostsPlainJSON("MNL")).thenReturn(node);
        mockMvc.perform(get("/api/weather/MNL"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"city\":\"Manila\",\"temperature\":\"27DC\"}"));
    }

}
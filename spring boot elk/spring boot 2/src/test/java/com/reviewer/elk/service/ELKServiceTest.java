package com.reviewer.elk.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.io.FileReader;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ELKServiceTest {

    @Autowired
    ELKService elkService;

    @MockBean
    ELKService mockElkService;

    @MockBean
    JSONParser mockJsonParser;

    @MockBean
    JSONObject mockJSONObject;

    @Test
    public void getAllFoodDetailsTest() throws Exception {
        JSONObject fruit1 = new JSONObject();
        fruit1.put("name", "apple");
        JSONArray json = new JSONArray();
        json.add(fruit1);
        FileReader mockFile = Mockito.mock(FileReader.class);
        Mockito.when(mockJsonParser.parse(mockFile)).thenReturn(fruit1);
        Mockito.when(mockJSONObject.get("data")).thenReturn(json);
        Mockito.when(mockElkService.getAllFoodDetails()).thenReturn(json);
        String expected = "[{\"name\":\"apple\"}]";
        Assertions.assertEquals(json, elkService.getAllFoodDetails());
    }

}

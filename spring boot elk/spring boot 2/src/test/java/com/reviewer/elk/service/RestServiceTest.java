package com.reviewer.elk.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RestServiceTest {

    @Autowired
    RestService restService;

    @MockBean
    RestService mockRestService;

    @Test
    public void getPostsPlainJSONTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String weatherJson =
                "{ \"city\" : \"Manila\", \"temperature\" : \"27DC\" }";
        JsonNode node = mapper.readTree(weatherJson);
        RestTemplate mockRestTemplate = Mockito.mock(RestTemplate.class);
        Mockito.when(mockRestTemplate.getForObject("URL", String.class))
                .thenReturn(weatherJson);
        ObjectMapper mockObjMapper = Mockito.mock(ObjectMapper.class);
        Mockito.when(mockObjMapper.readTree(weatherJson)).thenReturn(node);
        Mockito.when(mockRestService.getPostsPlainJSON("MNL")).thenReturn(node);

        Assertions.assertEquals(node, restService.getPostsPlainJSON("MNL"));
    }
}

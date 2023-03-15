package com.reviewer.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reviewer.dto.ProductDTO;
import com.reviewer.model.Product;
import com.reviewer.services.impl.ProductServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @MockBean
    ProductServiceImpl productServiceImpl;

    @Autowired
    MockMvc mockMvc;

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @Before
    public void setup() {
        product1 = new Product("sampleContId1", "Eco bag", 50, 20.00);

        product2 = new Product("sampleContId2", "Teddy Bear", 5, 1000.00);

        product3 = new Product("sampleContId2", "Electric Fan", 1, 999.99);

        product4 = new Product("sampleContId4", "Glass", 7, 8.95);
    }

    @Test
    public void retrieveAllProductsTest() throws Exception {
        ResponseEntity<List<Product>> products =
                ResponseEntity.ok().body(List.of(product1, product2, product3, product4));

        when(productServiceImpl.retrieveProducts()).thenReturn(products);

        mockMvc.perform(get("/v1/product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(4)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Eco bag")))
                .andDo(print());
        verify(productServiceImpl, atLeastOnce()).retrieveProducts();
    }

    @Test
    public void retrieveAllProductsWithEmptyReturnTest() throws Exception {
        when(productServiceImpl.retrieveProducts()).thenReturn(ResponseEntity.ok().body(new ArrayList<>()));

        mockMvc.perform(get("/v1/product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(0)))
                .andDo(print());
        verify(productServiceImpl, atLeastOnce()).retrieveProducts();
    }

    @Test
    public void createProductTest() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final String jsonContent = mapper.writeValueAsString(product2);

        ResponseEntity<Product> createProduct = ResponseEntity.ok().body(product2);

        when(productServiceImpl.saveProduct(any(ProductDTO.class))).thenReturn(createProduct);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/product")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("Teddy Bear")))
                .andDo(print());
        verify(productServiceImpl, atLeastOnce()).saveProduct(any(ProductDTO.class));
    }

    @Test
    public void updateProductTest() throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final String jsonContent = mapper.writeValueAsString(product3);

        ResponseEntity<Product> updateProduct = ResponseEntity.ok().body(product3);

        when(productServiceImpl.saveProduct(any(ProductDTO.class))).thenReturn(updateProduct);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/product")
                .content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is("sampleContId2")))
                .andExpect(jsonPath("$.name", Matchers.is("Electric Fan")))
                .andDo(print());
        verify(productServiceImpl, atLeastOnce()).saveProduct(any(ProductDTO.class));
    }

    @Test
    public void deleteProductTest() throws Exception {
        when(productServiceImpl.deleteProductById(any(String.class)))
                .thenReturn(ResponseEntity.ok().body(HttpStatus.OK));

        mockMvc.perform(delete("/v1/product/{id}", "sampleContId4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is("OK")))
                .andDo(print());
        verify(productServiceImpl, atLeastOnce()).deleteProductById(any(String.class));
    }

    @Test()
    public void deleteNonExistingProductTest() throws Exception {
        when(productServiceImpl.deleteProductById(any(String.class)))
                .thenReturn(ResponseEntity.ok().body(HttpStatus.INTERNAL_SERVER_ERROR));

        mockMvc.perform(delete("/v1/product/{id}", "sampleContId5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is("INTERNAL_SERVER_ERROR")))
                .andDo(print());
        verify(productServiceImpl, atLeastOnce()).deleteProductById(any(String.class));
    }
}

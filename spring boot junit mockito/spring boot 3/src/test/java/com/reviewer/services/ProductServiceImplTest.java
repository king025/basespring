package com.reviewer.services;

import com.reviewer.dao.ProductRepository;
import com.reviewer.dto.ProductDTO;
import com.reviewer.handlers.ProductNotFoundException;
import com.reviewer.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private RestTemplate restTemplate;

    private ProductDTO productDTO1;
    private Product product1;
    private ProductDTO productDTO211;
    private ProductDTO productDTO212;
    private Product product212;
    private Product product3;
    private Product productOth;
    private List<Product> products;

    @Before
    public void setup() {
        productDTO1 = new ProductDTO();
        productDTO1.setName("Sample product");
        productDTO1.setQuantity("77");
        productDTO1.setPrice("85.00");

        ModelMapper modelMapper = new ModelMapper();
        product1 = modelMapper.map(productDTO1, Product.class);

        productDTO211 = new ProductDTO();
        productDTO211.setId("3");
        productDTO211.setName("testProd1 edited");
        productDTO211.setQuantity("5");
        productDTO211.setPrice("4.99");

        productDTO212 = new ProductDTO();
        productDTO212.setId("3");
        productDTO212.setName("testProd1");
        productDTO212.setQuantity("6");
        productDTO212.setPrice("5.88");

        product212 = modelMapper.map(productDTO212, Product.class);

        product3 = new Product("sampleProdId1", "sampleProd1", 2, 3.00);

        productOth = new Product("sampleProdId1", "sampleProd1", 2, 3.00);

        products = Arrays.asList(product1, product212, product3);
    }

    @Test
    public void createProductWithoutIDTest() {
        when(productRepository.save(any(Product.class))).thenReturn(product1);
        Assert.assertNotNull(productService.saveProduct(productDTO1).getBody());
        Assert.assertEquals(product1, productService.saveProduct(productDTO1).getBody());
        verify(productRepository, atLeastOnce()).save(any(Product.class));
    }

    @Test
    public void createProductWithIDTest() {
        when(productRepository.findById(any(String.class))).thenReturn(Optional.empty());
        when(productRepository.save(any(Product.class))).thenReturn(product212);
        ResponseEntity<Product> createdProd = productService.saveProduct(productDTO212);
        Assert.assertNotNull(createdProd.getBody());
        Assert.assertEquals("3", Objects.requireNonNull(createdProd.getBody()).getId());
        Assert.assertEquals("testProd1", Objects.requireNonNull(createdProd.getBody()).getName());
        verify(productRepository, atLeastOnce()).findById(any(String.class));
        verify(productRepository, atLeastOnce()).save(any(Product.class));
    }

    @Test
    public void updateProductTest() {
        when(productRepository.findById(any(String.class))).thenReturn(Optional.ofNullable(product212));
        when(productRepository.save(any(Product.class))).thenReturn(product212);
        ResponseEntity<Product> updatedProduct = productService.saveProduct(productDTO211);
        Assert.assertNotNull(updatedProduct.getBody());
        Assert.assertEquals("3", Objects.requireNonNull(updatedProduct.getBody()).getId());
        Assert.assertEquals("testProd1 edited", Objects.requireNonNull(updatedProduct.getBody()).getName());
        verify(productRepository, atLeastOnce()).findById(any(String.class));
        verify(productRepository, atLeastOnce()).save(any(Product.class));
    }

    @Test
    public void retrieveProductsTest() {
        when(productRepository.findAll()).thenReturn(products);
        ResponseEntity<List<Product>> retrieveProducts = productService.retrieveProducts();
        Assert.assertNotNull(retrieveProducts);
        Assert.assertEquals(3, Objects.requireNonNull(retrieveProducts.getBody()).size());
        verify(productRepository, atLeastOnce()).findAll();
    }

    @Test(expected = ProductNotFoundException.class)
    public void retrieveProductsWithExceptionTest() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        productService.retrieveProducts();
        verify(productRepository, atLeastOnce()).findAll();
    }

    @Test
    public void deleteProductTest() {
        when(productRepository.findById(any(String.class))).thenReturn(Optional.ofNullable(product3));
        productService.deleteProductById("sampleProdId1");
        Assert.assertEquals(0, productRepository.findAll().size());
        Assert.assertEquals(HttpStatus.OK, productService.deleteProductById("sampleProdId1").getBody());
        verify(productRepository, atLeastOnce()).findById("sampleProdId1");
    }

    @Test()
    public void deleteNonExistingProductTest() {
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, productService.deleteProductById("noId").getBody());
    }

    @Test()
    public void getProductFromOtherAppByIdTest() {
        when(restTemplate.getForEntity("http://sampleUrl:8080/v1/product/sampleProdId1", Product.class))
                .thenReturn(new ResponseEntity<>(productOth, HttpStatus.OK));

        ResponseEntity<Product> retrieveProduct = productService.getProductFromOtherAppById("sampleProdId1");
        Assert.assertEquals(productOth, retrieveProduct.getBody());
        Assert.assertEquals(2, Objects.requireNonNull(retrieveProduct.getBody()).getQuantity());
        Assert.assertEquals("sampleProdId1", retrieveProduct.getBody().getId());
        verify(restTemplate, atLeastOnce()).getForEntity("http://sampleUrl:8080/v1/product/sampleProdId1", Product.class);
    }

    @Test()
    public void getEmptyProductFromOtherAppByIdTest() {
        when(restTemplate.getForEntity("http://sampleUrl:8080/v1/product/sampleProdId1", Product.class))
                .thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

        ResponseEntity<Product> retrieveProduct = productService.getProductFromOtherAppById("sampleProdId1");
        Assert.assertNull(retrieveProduct);
        verify(restTemplate, atLeastOnce()).getForEntity("http://sampleUrl:8080/v1/product/sampleProdId1", Product.class);
    }

}

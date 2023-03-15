package com.reviewer.services;

import com.reviewer.dto.ProductDTO;
import com.reviewer.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ResponseEntity<Product> saveProduct(ProductDTO product);
    ResponseEntity<List<Product>> retrieveProducts();
    ResponseEntity<HttpStatus> deleteProductById(String id);
    ResponseEntity<Product> getProductFromOtherAppById(String id);

}

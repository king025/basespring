package com.reviewer.controllers;

import com.reviewer.dto.ProductDTO;
import com.reviewer.model.Product;
import com.reviewer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequestMapping("/v1/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDto) {
        return productService.saveProduct(productDto);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> retrieveAllProducts() {
        return productService.retrieveProducts();
    }

    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String id) {
        return productService.deleteProductById(id);
    }

}

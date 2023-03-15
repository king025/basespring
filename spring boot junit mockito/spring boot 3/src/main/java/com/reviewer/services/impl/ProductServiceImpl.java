package com.reviewer.services.impl;

import com.reviewer.dao.ProductRepository;
import com.reviewer.dto.ProductDTO;
import com.reviewer.handlers.ProductNotFoundException;
import com.reviewer.model.Product;
import com.reviewer.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<Product> saveProduct(ProductDTO productDto) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productDto, Product.class);
        if (product.getId() == null) {
            return ResponseEntity.ok().body(productRepository.save(product));
        } else {
            Optional<Product> productOptional = productRepository.findById(product.getId());
            if (productOptional.isPresent()) {
                Product updateProduct = productOptional.get();
                updateProduct.setName(product.getName());
                updateProduct.setPrice(product.getPrice());
                updateProduct.setQuantity(product.getQuantity());
                return ResponseEntity.ok().body(productRepository.save(updateProduct));
            } else {
                return ResponseEntity.ok().body(productRepository.save(product));
            }
        }
    }

    @Override
    public ResponseEntity<List<Product>> retrieveProducts() {
        List<Product> products = productRepository.findAll();
        if (!CollectionUtils.isEmpty(products)) {
            return ResponseEntity.ok().body(products);
        } else {
            throw new ProductNotFoundException("No product/s exist");
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteProductById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().body(HttpStatus.OK);
        } else {
            return ResponseEntity.ok().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Product> getProductFromOtherAppById(String id) {
        ResponseEntity<Product> resp = restTemplate.getForEntity("http://sampleUrl:8080/v1/product/" + id, Product.class);
        return resp.getStatusCode() == HttpStatus.OK ? resp : null;
    }
}

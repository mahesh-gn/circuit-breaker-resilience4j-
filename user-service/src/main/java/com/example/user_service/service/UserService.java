package com.example.user_service.service;

import com.example.user_service.model.ProductDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

@Service
public class UserService {

    private static final String BASE_URL = "http://localhost:8081/products";

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "userService", fallbackMethod = "getAllAvailableProductsFallback")
    public List<ProductDto> getProducts(String category) {
        String url = category == null || category.isEmpty() ? BASE_URL : BASE_URL + "/category?category=" + category;
        return restTemplate.getForObject(url, List.class);
    }

    public List<ProductDto> getAllAvailableProductsFallback(Exception e) {
        return Stream.of(
                new ProductDto("1", "Bata", "Slippers", "Red", 100.0),
                new ProductDto("2", "Adidas", "Shoes", "Blue", 150.0),
                new ProductDto("3", "Shirt", "Clothes", "Green", 200.0),
                new ProductDto("4", "pants", "Clothes", "Yellow", 250.0),
                new ProductDto("5", "Clear", "Shampoo", "White", 300.0),
                new ProductDto("6", "chick", "Shampoo", "Black", 400.0)
        ).toList();
    }

}
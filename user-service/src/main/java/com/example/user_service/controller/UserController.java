package com.example.user_service.controller;

import com.example.user_service.model.ProductDto;
import com.example.user_service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/userService")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/displayProducts")
    public List<ProductDto> getProducts(@RequestParam(required = false) String category) {
        return userService.getProducts(category);
    }

}

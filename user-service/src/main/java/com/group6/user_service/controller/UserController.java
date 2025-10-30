package com.group6.user_service.controller;

import com.group6.user_service.model.User;
import com.group6.user_service.repository.UserRepository;
import com.group6.user_service.services.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final ProductClient productClient;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/products")
    public List<Object> getProductsForUsers() {
        return productClient.getProducts();
    }
}

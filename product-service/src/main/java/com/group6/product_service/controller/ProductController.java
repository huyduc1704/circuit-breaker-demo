package com.group6.product_service.controller;

import com.group6.product_service.model.Product;
import com.group6.product_service.model.enums.Category;
import com.group6.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productRepository.findByCategory(
                Enum.valueOf(Category.class, category.toUpperCase())
        );
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }
}

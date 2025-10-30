package com.group6.product_service.repository;

import com.group6.product_service.model.Product;
import com.group6.product_service.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}

package com.example.Recycling.Products.repository;


import com.example.Recycling.Products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}

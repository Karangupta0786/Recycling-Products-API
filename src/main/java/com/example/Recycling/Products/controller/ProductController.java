package com.example.Recycling.Products.controller;

import com.example.Recycling.Products.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Recycling.Products.model.Product;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAll(){
        return productRepo.findAll();
    }

    @GetMapping("Products/{id}")
    public Product getById(@PathVariable Integer id){
        if (productRepo.findById(id).isPresent()) {
            return productRepo.findById(id).get();
        }
        return null;
    }


}

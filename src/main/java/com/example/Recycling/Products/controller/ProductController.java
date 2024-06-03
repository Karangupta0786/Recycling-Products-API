package com.example.Recycling.Products.controller;

import com.example.Recycling.Products.repository.ProductRepo;
import com.example.Recycling.Products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Recycling.Products.model.Product;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product){
        return productService.add(product);
    }

    @GetMapping("/products")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id){
            return productService.getById(id);
    }

    @PutMapping("/products")
    public String update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "Product Deleted";
    }


}

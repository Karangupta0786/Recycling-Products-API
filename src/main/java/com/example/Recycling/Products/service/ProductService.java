package com.example.Recycling.Products.service;

import com.example.Recycling.Products.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Recycling.Products.model.Product;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public String add(Product product){
        productRepo.save(product);
        return "Product uploaded";
    }

    public Product getById(Long id){
        if (productRepo.findById(id).isPresent()) {
            return productRepo.findById(id).get();
        }
        return null;
    }

    public List<Product> getAll()
    {
        return productRepo.findAll();
    }

    public String delete(Long id){
        productRepo.deleteById(id);
        return "Product deleted!";
    }

    public String update(Product product){
        productRepo.getReferenceById(product.getId()).setName(product.getName());
        productRepo.getReferenceById(product.getId()).setLocation(product.getLocation());
        productRepo.getReferenceById(product.getId()).setPhone(product.getPhone());
        productRepo.getReferenceById(product.getId()).setQuantity(product.getQuantity());
        return "product updated.";
    }


}

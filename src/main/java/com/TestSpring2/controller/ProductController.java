package com.TestSpring2.controller;

import com.TestSpring2.dao.ProductDao;
import com.TestSpring2.exception.ProductNotfoundException;
import com.TestSpring2.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {
  
  @Autowired
  ProductDao repository;
  
  @GetMapping("/product")
  public List<Product> getAll() {
    return repository.findAll();
  }
  
  @GetMapping("/product/bulkcreate")
  public Product bulkcreate() {
    
    Product newProd = repository.save(new Product("Prod1", "desc 1."));
    
    return newProd;
  }
  
  @PostMapping("/product/create")
  public String create(@RequestBody Product product) {
    Product newProd = repository.save(product);
    return newProd.getId().toString();
  }
  
  @GetMapping("/product/{id}")
  public Optional<Product> getById(@PathVariable("id") UUID id) {
    if (!repository.findById(id).isPresent()) throw new ProductNotfoundException();
    
    Optional<Product> response = repository.findById(id);
    
    return response;
  }
  
  @PutMapping("/product/{id}")
  public Product update(@PathVariable("id") UUID id, @RequestBody Product product) {
    if (!repository.findById(id).isPresent()) throw new ProductNotfoundException();
    
    Optional<Product> obj = repository.findById(id);
    Product prod = obj.get();
    
    if (!product.getName().isEmpty()) {
      prod.setName(product.getName());
    }
    
    if (!product.getDescription().isEmpty()) {
      prod.setDescription(product.getDescription());
    }
    
    Product newProd = repository.save(prod);
    return newProd;
  }
  
  @DeleteMapping("/product/{id}")
  public String delete(@PathVariable("id") UUID id) {
    if (!repository.findById(id).isPresent()) throw new ProductNotfoundException();
    repository.deleteById(id);
    
    return id.toString();
  }
}

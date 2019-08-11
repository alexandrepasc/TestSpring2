package com.TestSpring2.controller;

import com.TestSpring2.dao.ProductDao;
import com.TestSpring2.exception.ProductNotfoundException;
import com.TestSpring2.model.Product;

import com.TestSpring2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {
  
  @Autowired
  ProductDao repository;
  
  @Autowired
  ProductService productService;
  
  @GetMapping("/product")
  public List<Product> getAll() {
    
    return productService.getProducts();
  }
  
  @GetMapping("/product/bulkcreate")
  public List<Product> bulkcreate() {
    
    return productService.addBulkProducts();
  }
  
  @PostMapping("/product/create")
  public String create(@RequestBody Product product) {
    
    return productService.addProduct(product);
  }
  
  @GetMapping("/product/{id}")
  public Optional<Product> getById(@PathVariable("id") UUID id) {
    
    return productService.getProduct(id);
  }
  
  @PutMapping("/product/{id}")
  public Product update(@PathVariable("id") UUID id, @RequestBody Product product) {
    
    return productService.putProduct(id, product);
  }
  
  @DeleteMapping("/product/{id}")
  public String delete(@PathVariable("id") UUID id) {
    
    return productService.delProduct(id);
  }
}

package com.TestSpring2.service;

import com.TestSpring2.dao.ProductDao;
import com.TestSpring2.exception.ProductNotfoundException;
import com.TestSpring2.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
  
  @Autowired
  ProductDao repository;
  
  @Override public List<Product> getProducts() {
    return repository.findAll();
  }
  
  @Override public List<Product> addBulkProducts() {
    
    List<Product> newProds = repository.saveAll(Arrays.asList(
        new Product("Prod bulk 1", "desc bulk 1."),
        new Product("Prod bulk 2", "desc bulk 2")
    ));
  
    return newProds;
  }
  
  @Override public String addProduct(Product product) {
    
    Product newProd = repository.save(product);
    
    return newProd.getId().toString();
  }
  
  @Override public Optional<Product> getProduct(UUID id) {
    if (!repository.findById(id).isPresent()) throw new ProductNotfoundException();
  
    Optional<Product> response = repository.findById(id);
  
    return response;
  }
  
  @Override public Product putProduct(UUID id, Product product) {
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
  
  @Override public String delProduct(UUID id) {
    if (!repository.findById(id).isPresent()) throw new ProductNotfoundException();
    
    repository.deleteById(id);
  
    return id.toString();
  }
}

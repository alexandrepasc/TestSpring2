package com.TestSpring2.service;

import com.TestSpring2.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
  
  public abstract List<Product> getProducts();
  
  public abstract List<Product> addBulkProducts();
  
  public abstract String addProduct(Product product);
  
  public abstract Optional<Product> getProduct(UUID id);
  
  public abstract Product putProduct(UUID id, Product product);
  
  public abstract String delProduct(UUID id);
}

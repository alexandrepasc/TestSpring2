package com.TestSpring2.dao;

import com.TestSpring2.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductDao extends JpaRepository<Product, UUID> {
}

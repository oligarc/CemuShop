package com.oligarc.online_shop.repository;

import com.oligarc.online_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByNameContainingIgnoreCase(String name);
}

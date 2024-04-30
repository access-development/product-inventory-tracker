package com.access.productInventoryTracker.repository;

import com.access.productInventoryTracker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // This interface method findAll() is provided by JpaRepository so no need to implement it.
    // You can add custom methods here if needed, for example: 
    // List<Product> findByCategory(String category);
}

package com.access.productInventoryTracker.service;

import com.access.productInventoryTracker.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    // Your methods here...
}

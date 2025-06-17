package com.access.productInventoryTracker.service;

import com.access.productInventoryTracker.dto.ProductDTO;

import java.util.List;

public interface ProductServiceInterface {
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice);
    List<ProductDTO> getProductsByCategory(String category);
    List<ProductDTO> getProductsByAvailability(boolean available);
}

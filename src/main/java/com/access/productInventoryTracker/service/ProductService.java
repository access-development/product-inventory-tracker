package com.access.productInventoryTracker.service;

import com.access.productInventoryTracker.dto.ProductDTO;
import com.access.productInventoryTracker.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.access.productInventoryTracker.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceInterface {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Helper method to convert Product to ProductDTO
    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getCategory(), /// THere was a bug which could have cause issue because where using toLowerCase here
            product.isAvailable()
        );
    }

    // Get all products as DTOs
    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }



    // Your filtering methods here...

/*
*
* **********************************************************
* ******IMPLEMENTATION FOR OUR CASE************************
* *********************************************************
*
* */
    @Override
    public List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findAll().stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        return Optional.ofNullable(getAllProducts())
                .orElse(Collections.emptyList())
                .stream()
                .filter(p -> category != null && category.equals(p.getCategory()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByAvailability(boolean available) {
        return getAllProducts().stream().filter(p -> p.isAvailable() == available).collect(Collectors.toList());
    }



    /*
     *
     * **********************************************************
     * ******IMPLEMENTATION FOR OUR REAL WORLD*******************
     * *********************************************************
     *
     * */


    public List<ProductDTO> getProductsByCategoryWithDB(String category) {
        return Optional.ofNullable(productRepository.findByCategory(category))
                .orElse(Collections.emptyList())
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByAvailabilityWithDB(boolean available) {
        return productRepository.findByAvailable(available).stream().map(this::convertToDTO).collect(Collectors.toList());
    }


}

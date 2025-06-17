package com.access.productInventoryTracker.service;

import com.access.productInventoryTracker.dto.ProductDTO;
import com.access.productInventoryTracker.model.Product;
import com.access.productInventoryTracker.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setupMockProducts() {
        List<Product>  mockProducts= Arrays.asList(
            new Product(1L, "Laptop", 1500.0, "Electronics", true),
            new Product(2L, "Smartphone", 800.0, "Electronics", false),
            new Product(3L, "Coffee Maker", 100.0, "Home Appliances", true),
            new Product(4L, "Blender", 150.0, "Home Appliances", true),
            new Product(5L, "T-Shirt", 30.0, "Apparel", true),
            new Product(6L, "Jeans", 45.0, "Apparel", true),
            new Product(7L, "Desk Lamp", 89.99, "Home Appliances", false),
            new Product(8L, "Wall Art", 120.0, "Home Decor", true),
            new Product(9L, "Sneakers", 75.0, "Apparel", true),
            new Product(10L, "Wristwatch", 250.0, "Accessories", false),
            new Product(11L, "Backpack", 60.0, "Accessories", true),
            new Product(12L, "Microwave Oven", 99.0, "Home Appliances", false),
            new Product(13L, "Floor Rug", 150.0, "Home Decor", true),
            new Product(14L, "Speaker", 300.0, "Electronics", true),
            new Product(15L, "E-reader", 200.0, "Electronics", false),
            new Product(16L, "Gaming Console", 499.99, "Electronics", true),
            new Product(17L, "Office Chair", 220.0, "Office Supplies", true),
            new Product(18L, "Pen Set", 29.99, "Office Supplies", true),
            new Product(19L, "Mountain Bike", 489.0, "Outdoor", true),
            new Product(20L, "Camping Tent", 270.0, "Outdoor", false)
        );

        when(productRepository.findAll()).thenReturn(mockProducts);
        when(productRepository.findByCategory("Electronics")).thenReturn(mockProducts.stream().filter(c-> c.getCategory().equals("Electronics")).toList());
        when(productRepository.findByAvailable(true)).thenReturn(mockProducts.stream().filter(Product::isAvailable).toList());
    }

    // Your tests here...


    /*
    *
    * AllProduct test cases
    *
    * */

    @Test
    void testAllProductsEmpty(){
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> allProducts = productService.getAllProducts();
        assertTrue(allProducts.isEmpty());
    }


    @Test
    void testAllProducts() {
        List<ProductDTO> allProducts = productService.getAllProducts();
        assertNotNull(allProducts);
        assertEquals(20, allProducts.size());
    }

    /*
    *
    * Price range test cases
    *
    * */

    @Test
    void testGetProductsByPriceRangeZero() {
        List<ProductDTO> result = productService.getProductsByPriceRange(0, 0);
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetProductsByPriceRangeExactMatch() {
        List<ProductDTO> result = productService.getProductsByPriceRange(100, 100);
        assertEquals(1, result.size());
    }

    @Test
    void testGetProductsByPriceRange() {
        List<ProductDTO> result = productService.getProductsByPriceRange(100, 300);
        assertEquals(9, result.size());
    }

    @Test
    void testGetProductsByPriceRangeMismatch() {
        List<ProductDTO> result = productService.getProductsByPriceRange(2000, 3300);
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetProductsByPriceRangeInvalidRange() {
        List<ProductDTO> result = productService.getProductsByPriceRange(4000, 200);
        assertEquals(0, result.size());
    }

    @Test
    void testGetProductsByPriceRangeOnEmpty() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> result = productService.getProductsByPriceRange(100, 200);
        assertEquals(0, result.size());
    }

    /*
    *
    * Category test cases
    *
    * */



    //Category Bug Case
    //these two cases will fail if we have bug of lowercase
    //testGetProductsByCategoryTestBug and testGetProductsByCategoryTestBug2

    @Test
    void testGetProductsByCategoryTestBug() {
        List<ProductDTO> result = productService.getProductsByCategory("electronics");
        assertTrue(result.isEmpty());
    }
    @Test
    void testGetProductsByCategoryTestBug2() {
        String result = productService.getAllProducts().getFirst().getCategory();
        assertEquals("Electronics", result);
    }

    /*  BUG Cases Ends  */


    @Test
    void testGetProductsByCategoryEmptyOrMisMatch() {
        List<ProductDTO> result = productService.getProductsByCategory("");
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetProductsByCategoryNull() {
        List<ProductDTO> result = productService.getProductsByCategory(null);
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetProductsByCategoryMatch() {
        List<ProductDTO> result = productService.getProductsByCategory("Apparel");
        assertEquals(3, result.size());
    }

    @Test
    void testGetProductsByCategoryNoMatch() {
        List<ProductDTO> result = productService.getProductsByCategory("Toys");
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetProductsByCategoryOnEmpty() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> result = productService.getProductsByCategory("Toys");
        assertEquals(0, result.size());
        assertTrue(result.isEmpty());
    }

    /*
    *
    * Availability cases
    *
    * */

    @Test
    void testGetProductsByAvailabilityOnEmpty() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> result = productService.getProductsByAvailability(true);
        assertEquals(0, result.size());
    }

    @Test
    void testGetProductsByAvailabilityTrue() {
        List<ProductDTO> result = productService.getProductsByAvailability(true);
        assertEquals(14, result.size());
        assertTrue(result.stream().allMatch(ProductDTO::isAvailable));
    }


    @Test
    void testGetProductsByAvailabilityFalse() {
        List<ProductDTO> result = productService.getProductsByAvailability(false);
        assertEquals(6, result.size());
        assertTrue(result.stream().noneMatch(ProductDTO::isAvailable));
    }



    /*
    *
    * With DB Methods
    *
    * */
    @Test
    void testGetProductsByCategoryDB() {
        List<ProductDTO> result = productService.getProductsByCategoryWithDB("Electronics");
        assertEquals(5, result.size());
    }

    @Test
    void testGetProductsByAvailabilityDB() {
        List<ProductDTO> result = productService.getProductsByAvailabilityWithDB(true);
        assertFalse(result.isEmpty());
        assertEquals(14, result.size());
    }



}
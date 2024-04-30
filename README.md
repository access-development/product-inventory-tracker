# Product Inventory Tracker

## Task: Implement Filtering Methods in the Service Layer

### Overview

You are required to enhance the functionality of our Product Inventory Tracker by adding features that allow users to search for products based on specific criteria. Your task involves implementing methods in the service layer (`ProductService`) to enable filtering of product entries by various product attributes.

### Requirements

**Coding Standards:**

- Uphold clean code principles to ensure your code is both readable and maintainable, such as:
  - **Proper naming conventions:** Choose clear and descriptive names for methods and parameters.
  - **Usage of Java’s Optional:** Apply Java’s Optional to gracefully handle potential null values.
  - **Efficient use of functional interfaces and stream operations:** Utilize these features for effective data processing.

### Workflow Instructions

To successfully complete your assessment for the Product Inventory Tracker, please follow the steps outlined below. These steps are crafted to evaluate your coding, testing, and problem-solving skills using Java and Spring Boot.

1. **Review Use Cases:**
   - Begin by examining the three provided use cases. Each describes a specific requirement for the `ProductService` class.
2. **Implement Service Methods:**
   - Code the service methods as specified in `ProductService.java`, adhering to clean code principles and efficient data processing using Java Stream API.
3. **Write Unit Tests:**
   - For each service method, compose a unit test in `ProductServiceTest.java`. Ensure each test robustly verifies the functionality of the respective service method, including edge cases.
4. **Run Unit Tests:**
   - Execute the unit tests to confirm they pass. Focus solely on your testing; running the entire application isn't necessary for this assessment. Make sure your tests are comprehensive and consider various scenarios, including edge cases.
5. **Commit Your Code:**
   - After developing the service methods and confirming that all tests pass, commit your code and push it to your assigned branch for review.

### Mock Data Setup

A method creating mock `Product` data and configuring `findAll()` to return this data will be provided in the `ProductServiceTest.java` class. This setup allows you to focus primarily on crafting the business logic and testing.

### Use Cases

1. **Price Range Filter:**
   - **Task:** Implement a method to return a list of `ProductDTO` objects that fall within a specified price range.
   - **Testing:** Ensure your unit test verifies that only products within the price range are returned and handles edge cases like no products within the range.
  
2. **Category Filter:**
   - **Task:** Write a service method to return a list of `ProductDTO` objects matching a specified category.
   - **Testing:** Verify through testing that the method correctly filters products by category, and include a scenario where the specified category is absent in the data.

3. **Availability Filter:**
   - **Task:** Craft a method that returns a list of `ProductDTO` objects based on their availability status.
   - **Testing:** Develop a unit test that ensures products are accurately filtered by their availability status and consider scenarios where products are both available and unavailable.

### Summary

This workflow and the associated tasks are designed to assess your technical skills in Java backend services development and effective unit testing. Please complete each part of the task as described while maintaining clean and readable code throughout your implementation.

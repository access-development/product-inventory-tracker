# Product Inventory Tracker

## Task: Implement Filtering Methods in the Service Layer

### Overview

You are required to improve our Product Inventory Tracker by adding features that let users search for products using specific details. Your job is to add methods in the service layer (`ProductService`) to filter product entries based on different product attributes.

### Requirements

**Coding Standards:**

- Follow clean code rules to make your code easy to read and maintain:
  - **Clear naming:** Use names for methods and parameters that explain their purpose.
  - **Java’s Optional:** Use Java’s Optional to safely handle cases where values might be missing (null).
  - **Streams and functional interfaces:** Use these Java features to process data efficiently.

### Setup Instructions

**Project Requirements:**

- **Java 21**
- **Maven**

We recommend using **SDKMAN!** to set up your development environment. It helps manage different versions of tools like Java and Maven on Unix-based systems.

### Installing SDKMAN! and Required Software

1. **Install SDKMAN!:**
   Open your terminal and run:

   ```bash
   curl -s "https://get.sdkman.io" | bash
   ```

   After it installs, start a new terminal or run:

   ```bash
   source "$HOME/.sdkman/bin/sdkman-init.sh"
   ```

   Check if it works by running:

   ```bash
   sdk version
   ```

2. **Install Java 21 and Maven Using SDKMAN!:**
   - **Java:**

     ```bash
     sdk install java 21.0.0-zulu
     ```

   - **Maven:**

     ```bash
     sdk install maven
     ```

   Confirm the correct versions are installed:

   ```bash
   java -version
   mvn -version
   ```

### Setting Up the Project

After installing Java and Maven, prepare your project:

1. **Clone the project repository** from GitHub (use the link we provided).
2. Create a new branch for your work (example: `feature/your-username`).
3. Go to the project folder where the `pom.xml` file is.
4. Run `mvn clean install` to build the project and download all dependencies.

Your environment is now ready. If you have problems with SDKMAN!, Java, or Maven, ask us for help.

### Workflow Instructions

To complete this task, follow these steps. We will review your coding, testing, and problem-solving skills in Java and Spring Boot. **Important:** We expect you to submit your work as a Pull Request.

1. **Review Use Cases:**
   - Read the three use cases below. Each explains a requirement for the `ProductService` class.
2. **Implement Service Methods:**
   - Write the methods in `ProductService.java`. Use clean code principles and Java Stream API for efficient data processing.
3. **Write Unit Tests:**
   - For each method, create a unit test in `ProductServiceTest.java`. Test normal cases and edge cases (like empty results).
4. **Run Unit Tests:**
   - Run your tests to make sure they pass. You do not need to run the full application—just focus on your tests.
5. **Commit Your Code:**
   - Save your changes with `git commit`. You can make as many commits as you need.
6. **Push Your Branch:**
   - Push your branch to the repository with `git push`.
7. **Create a Pull Request:**
   - Go to GitHub, find your branch, and create a Pull Request (PR) to the `main` branch. This is how we will review your work. **We will not review your code without a Pull Request.**

### Mock Data Setup

The `ProductServiceTest.java` class includes a method with mock `Product` data and a `findAll()` method that returns this data. Use this to focus on writing business logic and tests.

### Use Cases

1. **Price Range Filter:**
   - **Task:** Write a method to return a list of `ProductDTO` objects with prices in a given range.
   - **Testing:** Test that only products in the range are returned. Include a test for when no products match.

2. **Category Filter:**
   - **Task:** Write a method to return a list of `ProductDTO` objects for a specific category.
   - **Testing:** Test that the method filters by category correctly. Include a test for a category with no products.

3. **Availability Filter:**
   - **Task:** Write a method to return a list of `ProductDTO` objects based on availability (true or false).
   - **Testing:** Test that products are filtered by availability. Include tests for both available and unavailable products.

### Summary

This task tests your skills in Java backend development and unit testing. Complete each step as described, keep your code clean and clear, and submit your work with a Pull Request. If you are unsure about any step, contact us for help.

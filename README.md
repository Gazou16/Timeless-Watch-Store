# Timeless Watch Store
[![Ask DeepWiki](https://devin.ai/assets/askdeepwiki.png)](https://deepwiki.com/Gazou16/Timeless-Watch-Store)

This repository contains the backend service for the Timeless Watch Store, a comprehensive management system built with Spring Boot. The application is designed with a modular architecture, separating concerns into distinct subdomains for customer relations, human resources, and inventory management.

## Project Structure

The application is organized into the following subdomains, promoting loose coupling and high cohesion:

*   **`customerrelationssubdomain`**: Manages all customer-related data and operations, including personal details, addresses, and contact information.
*   **`humanresourcessubdomain`**: Handles employee and department management. This includes employee records, salaries, positions, and department structures.
*   **`inventorymanagementsubdomain`**: A foundational module for managing watch inventory.

Each subdomain follows a layered architecture:
*   **Presentation Layer**: Exposes RESTful API endpoints for interaction.
*   **Business Layer**: Contains the core business logic and services.
*   **Data Access Layer**: Defines entities and repositories for database interaction using Spring Data JPA.
*   **Mapper Layer**: Uses MapStruct to map between DTOs (Request/Response Models) and JPA entities.

## Features

*   **Customer Management**: Full CRUD (Create, Read, Update, Delete) operations for customer records.
*   **Employee Management**: Full CRUD operations for employee data, including personal details, address, salary, and position.
*   **Department Management**: Full CRUD operations for departments, including managing associated job positions.
*   **RESTful API**: A well-defined API for interacting with the system's resources.
*   **Exception Handling**: Global exception handling for providing clear error responses.
*   **Containerization**: Docker and Docker Compose support for easy setup and deployment.

## Technologies Used

*   **Backend**: Java 17, Spring Boot 3, Spring Data JPA, Spring Modulith
*   **Database**: MySQL, PostgreSQL, H2 (for testing)
*   **Build Tool**: Gradle
*   **Utilities**: Lombok, MapStruct
*   **Containerization**: Docker, Docker Compose

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 17 or later
*   Docker and Docker Compose

### Running with Docker

The recommended way to run the application is by using Docker Compose, which will set up both the application and a MySQL database container.

1.  Clone the repository:
    ```bash
    git clone https://github.com/gazou16/Timeless-Watch-Store.git
    cd Timeless-Watch-Store
    ```

2.  Build and run the application using Docker Compose:
    ```bash
    docker compose up --build
    ```

The application will be accessible at `http://localhost:8080`.

A PhpMyAdmin instance is also included for easy database management, accessible at `http://localhost:5013`.

### Running Locally

You can also run the application using your IDE.
1.  Open the project in your favorite IDE (e.g., IntelliJ IDEA).
2.  Set the active Spring profile to `h2` in your run configuration. This will use an in-memory H2 database.
3.  Run the `TimelessWatchStoreApplication` main class.

The application will start on `http://localhost:8080`, and the H2 console will be available at `http://localhost:8080/h2-console`.

## API Endpoints

### Customer Relations

*   `GET /api/v1/customers`: Get a list of all customers.
*   `GET /api/v1/customers/{customerId}`: Get a specific customer by their ID.
*   `GET /api/v1/customers/filter/{country}`: Get customers filtered by country.
*   `POST /api/v1/customers`: Add a new customer.
*   `PUT /api/v1/customers/{customerId}`: Update an existing customer.
*   `DELETE /api/v1/customers/{customerId}`: Delete a customer by their ID.
*   `DELETE /api/v1/customers?emailAddress={email}`: Delete a customer by their email address.

### Human Resources - Departments

*   `GET /api/v1/departments`: Get a list of all departments.
*   `GET /api/v1/departments/{departmentId}`: Get a specific department by its ID.
*   `POST /api/v1/departments`: Add a new department.
*   `PUT /api/v1/departments/{departmentId}`: Update an existing department.
*   `DELETE /api/v1/departments/{departmentId}`: Delete a department.

### Human Resources - Employees

*   `GET /api/v1/employees`: Get a list of all employees.
*   `GET /api/v1/employees/{employeeId}`: Get a specific employee by their ID.
*   `POST /api/v1/employees`: Add a new employee.
*   `PUT /api/v1/employees/{employeeId}`: Update an existing employee.
*   `DELETE /api/v1/employees/{employeeId}`: Delete an employee.
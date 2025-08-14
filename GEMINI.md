# Project Overview

This is a Java Spring Boot application that appears to be a food delivery service called "eats". It uses Maven for dependency management and includes dependencies for Spring Web, Spring Data JPA, Spring Security, and Flyway for database migrations. The application is configured to connect to a MySQL database.

The project is structured as a monolith and follows the standard Maven project layout. The main source code is located in `src/main/java`, and database migrations are in `src/main/resources/db/migration`.

# Building and Running

## Prerequisites

*   Java 1.8
*   Maven
*   Docker

## Running the Application

1.  **Start the database:**
    ```bash
    docker-compose up -d
    ```

2.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

The application will be available at `http://localhost:8080`.

# Development Conventions

*   **Database Migrations:** Database changes are managed with Flyway. SQL migration files are located in `src/main/resources/db/migration`.
*   **Authentication:** The application uses JSON Web Tokens (JWT) for authentication.
*   **API:** The application exposes a REST API. The controllers are located in `src/main/java/br/com/caelum/eats/controller`.

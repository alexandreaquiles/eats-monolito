# Eats-Monolito

This is a monolithic implementation of a food delivery service called "Eats".

## About the Project

This project is a Java Spring Boot application that provides a REST API for a food delivery service. It uses Maven for dependency management and includes dependencies for Spring Web, Spring Data JPA, Spring Security, and Flyway for database migrations. The application is configured to connect to a MySQL database.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

*   Java 1.8
*   Maven
*   Docker

### Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/alexandreaquiles/eats-monolito.git
    ```

2.  **Start the database:**
    ```bash
    docker-compose up -d
    ```

3.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

The application will be available at `http://localhost:8080`.

## Usage

Once the application is running, you can use a tool like `curl` or Postman to interact with the API.

## API Endpoints

The main API endpoints are:

*   `/auth` - Authentication
*   `/avaliacoes` - Reviews
*   `/cardapios` - Menus
*   `/categorias-do-cardapio` - Menu Categories
*   `/formas-de-pagamento` - Payment Methods
*   `/horarios-de-funcionamento` - Opening Hours
*   `/itens-do-cardapio` - Menu Items
*   `/pagamentos` - Payments
*   `/pedidos` - Orders
*   `/restaurantes` - Restaurants
*   `/tipos-de-cozinha` - Cuisine Types

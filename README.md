# Eats-Monolito

Esta é uma implementação monolítica de um serviço de entrega de comida chamado "Eats".

## Sobre o Projeto

Este projeto é uma aplicação Java Spring Boot que fornece uma API REST para um serviço de entrega de comida. Ele utiliza o Maven para gerenciamento de dependências e inclui dependências para Spring Web, Spring Data JPA, Spring Security e Flyway para as migrações do banco de dados. A aplicação está configurada para se conectar a um banco de dados MySQL.

## Começando

Estas instruções te ajudarão a obter uma cópia do projeto e executá-lo em sua máquina local para fins de desenvolvimento e teste.

### Pré-requisitos

  * Java 1.8
  * Maven
  * Docker

### Instalação

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/alexandreaquiles/eats-monolito.git
    ```

2.  **Inicie o banco de dados:**

    ```bash
    docker-compose up -d
    ```

3.  **Execute a aplicação:**

    ```bash
    ./mvnw spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Uso

Assim que a aplicação estiver em execução, você pode usar uma ferramenta como o `curl` ou o Postman para interagir com a API.

## Endpoints da API

Os principais endpoints da API são:

  * `/auth` - Autenticação
  * `/avaliacoes` - Avaliações
  * `/cardapios` - Cardápios
  * `/categorias-do-cardapio` - Categorias do Cardápio
  * `/formas-de-pagamento` - Formas de Pagamento
  * `/horarios-de-funcionamento` - Horários de Funcionamento
  * `/itens-do-cardapio` - Itens do Cardápio
  * `/pagamentos` - Pagamentos
  * `/pedidos` - Pedidos
  * `/restaurantes` - Restaurantes
  * `/tipos-de-cozinha` - Tipos de Cozinha

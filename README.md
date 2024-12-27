# Spring Boot Blog REST API

## Project Overview

This project is a Spring Boot-based REST API for a blogging platform. It provides essential functionalities for creating, retrieving, updating, and deleting blog posts, comments, and categories. It also includes user authentication and authorization functionalities, allowing for secure access control.  

## Features

- **User Authentication and Authorization:** Secure user registration, login, and access control using Spring Security and JWTs.
- **Blog Posts Management:** API endpoints to create, retrieve, update, and delete blog posts.
- **Comments Management:** Allows users to add, retrieve, and delete comments on blog posts.
- **Categories Management:** Administer categories for blog posts.
- **Order and Payment Processing:** Basic order processing functionalities with integrated payment simulations.  


## Prerequisites

- Java 17 or higher
- Maven
- MySQL  

## Technology Stack

- **Spring Boot** - Framework for creating standalone, production-grade Spring based applications.
- **Spring Security** - Authentication and access-control framework.
- **Spring Data JPA** - Persistence layer framework to interact with the database.
- **JWT** - JSON Web Tokens for secure transmission of information.
- **ModelMapper** - For mapping between model data.
- **SpringDoc OpenAPI** - Automated JSON API documentation.  


## Setup and Installation

1. **Clone the repository:**
   ```
   git clone [your-repository-url]
   cd springboot-blog-rest-api
   
2. **Database Configuration:**  
   Update the ```src/main/resources/application.properties``` file with your MySQL database credentials and URL.  **
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
   
3. Run the Application: Build and run the application using Maven.
    ```
    mvn clean install
    mvn spring-boot:run  


## API Endpoints

Detail some of the critical endpoints, e.g.,

- `POST /api/auth/signup` - Register a new user.
- `POST /api/auth/login` - Login for existing users.
- `GET /api/posts` - Retrieve all posts.
- `POST /api/posts` - Create a new post.
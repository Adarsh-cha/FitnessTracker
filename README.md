🏋️ FitnessTracker

A backend-focused fitness tracking REST API built with Java, Spring Boot, Spring Data JPA, PostgreSQL, Spring Security, JWT, and Docker.

FitnessTracker allows users to securely manage their fitness activities through REST APIs. The application implements authentication, authorization, CRUD operations, database persistence, request validation, and API documentation with Swagger/OpenAPI.

🚀 Features

1. 🔐 User authentication and authorization
2. JWT-based authentication
3. 👤 User management
4. 🏃 Fitness activity tracking
5. ➕ Create fitness activities
6. 📋 View fitness activities
7. ✏️ Update fitness activities
8. 🗑️ Delete fitness activities
9. PostgreSQL database integration
10. 🔗 RESTful APIs
11. ✅ Request validation
12. 📖 Swagger/OpenAPI API documentation
13. 🐳 Docker support
14. Layered Spring Boot architecture

🛠️ Tech Stack
Technology	Purpose
Java 21	Programming language
Spring Boot	Backend framework
Spring Web	REST API development
Spring Data JPA	Database interaction
Hibernate	ORM
PostgreSQL	Relational database
Spring Security	Authentication & authorization
JWT	Stateless authentication
Lombok	Boilerplate code reduction
Maven	Dependency management & build
Swagger / OpenAPI	API documentation
Docker	Containerization

## 🛠️ Tech Stack

| Technology        | Purpose                        |
| ----------------- | ------------------------------ |
| Java 21           | Programming language           |
| Spring Boot       | Backend framework              |
| Spring Web        | REST API development           |
| Spring Data JPA   | Database interaction           |
| Hibernate         | ORM                            |
| PostgreSQL        | Relational database            |
| Spring Security   | Authentication & authorization |
| JWT               | Stateless authentication       |
| Lombok            | Boilerplate code reduction     |
| Maven             | Dependency management & build  |
| Swagger / OpenAPI | API documentation              |
| Docker            | Containerization               |


## 🏗️ Architecture

The application follows a layered architecture:

```text
                Client
                  │
                  ▼
          ┌─────────────────┐
          │   REST API      │
          │   Controller    │
          └────────┬────────┘
                   │
                   ▼
          ┌─────────────────┐
          │    Service      │
          │     Layer       │
          └────────┬────────┘
                   │
                   ▼
          ┌─────────────────┐
          │   Repository    │
          │     Layer       │
          └────────┬────────┘
                   │
                   ▼
          ┌─────────────────┐
          │   PostgreSQL    │
          │    Database     │
          └─────────────────┘



Authentication Flow: 

User
 │
 │ Login
 ▼
Authentication API
 │
 ▼
Spring Security
 │
 ▼
Validate Credentials
 │
 ▼
Generate JWT
 │
 ▼
Client
 │
 │ Authorization: Bearer <JWT>
 ▼
JWT Filter
 │
 ▼
Validate Token
 │
 ▼
Protected API

🔐 Authentication & Authorization
The application uses Spring Security with JWT for stateless authentication.

Authentication Flow
User submits login credentials.
Spring Security authenticates the user.
The application generates a JWT.
The client stores the token.
The token is sent with subsequent API requests.
The security layer validates the JWT.
Valid requests are allowed to access protected resources.

Example:- Authorization: Bearer <your-jwt-token>


🗄️ Database

The project uses PostgreSQL as the relational database and Spring Data JPA/Hibernate for persistence.

General data flow:

REST Request
     │
     ▼
Controller
     │
     ▼
Service
     │
     ▼
JPA Repository
     │
     ▼
Hibernate
     │
     ▼
PostgreSQL

JPA is responsible for mapping Java entities to database tables and Hibernate handles the ORM implementation.

📖 API Documentation

Swagger/OpenAPI is integrated into the application for API documentation and testing.

After starting the application, access the Swagger UI at:

http://localhost:8080/swagger-ui/index.html

From Swagger UI, you can:

View available endpoints
Inspect request/response models
Test APIs
Provide JWT authentication for protected endpoints

⚙️ Getting Started
Prerequisites

Make sure you have:

Java 21
Maven
PostgreSQL
Git
Docker (optional)

📂 Project Structure
FitnessTracker/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   │
│   │   └── resources/
│   │       └── ...
│   │
│   └── test/
│
├── .gitignore
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

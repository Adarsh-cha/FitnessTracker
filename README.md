# 🏋️ FitnessTracker

A backend-focused fitness tracking REST API built with **Java, Spring Boot, Spring Data JPA, PostgreSQL, Spring Security, JWT, and Docker**.

FitnessTracker allows users to securely manage their fitness activities through REST APIs. The application implements authentication, authorization, CRUD operations, database persistence, request validation, and API documentation with Swagger/OpenAPI.

---

## 🚀 Features

- 🔐 User authentication and authorization
- 🎫 JWT-based authentication
- 👤 User management
- 🏃 Fitness activity tracking
- ➕ Create fitness activities
- 📋 View fitness activities
- ✏️ Update fitness activities
- 🗑️ Delete fitness activities
- 🗄️ PostgreSQL database integration
- 🔗 RESTful APIs
- ✅ Request validation
- 📖 Swagger/OpenAPI API documentation
- 🐳 Docker support
- 🧩 Layered Spring Boot architecture

---

## 🛠️ Tech Stack

| Technology        | Purpose                        |
|-------------------|--------------------------------|
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

---

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
```

### 🔐 Authentication Flow

```text
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
```

---

## 🔐 Authentication & Authorization

The application uses **Spring Security with JWT** for stateless authentication.

### Authentication Flow

1. User submits login credentials.
2. Spring Security authenticates the user.
3. The application generates a JWT.
4. The client stores the token.
5. The token is sent with subsequent API requests.
6. The security layer validates the JWT.
7. Valid requests are allowed to access protected resources.

Example:

```http
Authorization: Bearer <your-jwt-token>
```

---

## 🗄️ Database

The project uses **PostgreSQL** as the relational database and **Spring Data JPA/Hibernate** for persistence.

### Data Flow

```text
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
```

JPA is responsible for mapping Java entities to database tables, while Hibernate handles the ORM implementation.

---

## 📖 API Documentation

Swagger/OpenAPI is integrated into the application for API documentation and testing.

After starting the application, access Swagger UI at:

```text
http://localhost:8080/swagger-ui/index.html
```

From Swagger UI, you can:

- View available endpoints
- Inspect request and response models
- Test APIs
- Provide JWT authentication for protected endpoints

---

## ⚙️ Getting Started

### Prerequisites

Make sure you have:

- Java 21
- Maven
- PostgreSQL
- Git
- Docker (optional)

---

## 📥 Clone Repository

```bash
git clone https://github.com/Adarsh-cha/FitnessTracker.git
cd FitnessTracker
```

---

## 🗄️ Configure PostgreSQL

Create a PostgreSQL database:

```sql
CREATE DATABASE fitness_tracker;
```

Configure your database credentials in the Spring Boot configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/fitness_tracker
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

## ▶️ Run the Application

### Using Maven

```bash
./mvnw spring-boot:run
```

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Build the Project

```bash
./mvnw clean package
```

### Run the Generated JAR

```bash
java -jar target/*.jar
```

The application will be available at:

```text
http://localhost:8080
```

## 📂 Project Structure

```text
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
```

---

## 🧠 Key Concepts Demonstrated

- REST API development
- Layered architecture
- Dependency Injection
- Spring Boot
- Spring Web
- Spring Security
- JWT authentication
- Authentication & Authorization
- Spring Data JPA
- Hibernate ORM
- PostgreSQL integration
- Request validation
- CRUD operations
- Swagger/OpenAPI
- Docker containerization
- Maven project management

---

## 🔄 Request Lifecycle

A typical protected request follows this flow:

```text
HTTP Request
     │
     ▼
Spring Security Filter Chain
     │
     ▼
JWT Validation
     │
     ▼
Authentication Context
     │
     ▼
Controller
     │
     ▼
Service
     │
     ▼
Repository
     │
     ▼
Hibernate / JPA
     │
     ▼
PostgreSQL
     │
     ▼
HTTP Response

# 🌟 Spring Boot API with JWT Auth and Swagger UI

This API is built using **Spring Boot**, integrates **JWT authentication**, and uses **PostgreSQL** as the database.
The API is fully containerized with **Docker Compose** and comes with pre-configured **Swagger UI** for easy API exploration.

## 🚀 How to Run the Project
## 1 Clone the Repository

```bash
git clone https://github.com/Ulisses22/dockerized-spring-api.git
cd spring-boot-api-jwt

```
## 2 Configure Environment Variables
**application.properties** (you can use .env file to Dynamic configuration)

```bash
spring.datasource.username=postgres
spring.datasource.password=root
```

**docker-compose.yml** (you can use .env file to Dynamic configuration)
```bash
POSTGRES_USER: postgres
POSTGRES_PASSWORD: root
SPRING_DATASOURCE_USERNAME: postgres
SPRING_DATASOURCE_PASSWORD: root
```

## 3 Run

```
docker-compose up --build     # Build and run containers
```

## Endpoints

| Endpoint             | Method | Description              | Auth Required |
|----------------------|--------|--------------------------|---------------|
| `/api/auth/login`    | POST   | Log in and get JWT token | ❌            |
| `/api/auth/register` | POST   | Register a new user      | ❌            |
| `/api/auth/activate` | GET    | Activate a new user      | ❌            |
| `/api/private`       | GET    | Private content          | ✅            |
| `/api/public`        | GET    | Public content           | ❌            |

## Swagger Documentation
URL: http://localhost:8080/swagger-ui.html

## ⚙️ Tech Stack

- Backend: Spring Boot, Spring Security, JWT
- Database: PostgreSQL
- Containerization: Docker, Docker Compose
- Documentation: Swagger UI
- Validation: Hibernate Validator

## Preview

![alt text](https://github.com/Ulisses22/dockerized-spring-api/blob/b60507be7857256a893c3a62ada59d66ed8c3dc0/Screenshot.png?raw=true)


### Enjoy coding! 💻✨

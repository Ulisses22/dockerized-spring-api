# 🌟 Spring Boot API with JWT Authentication 🚀

This API is built using **Spring Boot**, integrates **JWT authentication**, and uses **PostgreSQL** as the database.
The API is fully containerized with **Docker Compose** and comes with pre-configured **Swagger UI** for easy API exploration.

## 🚀 How to Run the Project
1️⃣ Clone the Repository

```bash
git clone https://github.com/your-repo/spring-boot-api-jwt.git
cd spring-boot-api-jwt

```
## 2️⃣ Configure Environment Variables
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

## 2️⃣ Run

```
docker-compose up --build     # Build and run containers
```

## 📜 Endpoints

| Endpoint             | Method | Description              | Auth Required |
|----------------------|--------|--------------------------|---------------|
| `/api/auth/login`    | POST   | Log in and get JWT token | ❌            |
| `/api/auth/register` | POST   | Register a new user      | ❌            |
| `/api/private`       | GET    | Private content          | ✅            |
| `/api/public`        | GET    | Public content           | ❌            |

## 📜 Swagger Documentation
URL: http://localhost:8080/swagger-ui.html

## ⚙️ Tech Stack

- Backend: Spring Boot, Spring Security, JWT
- Database: PostgreSQL
- Containerization: Docker, Docker Compose
- Documentation: Swagger UI
- Validation: Hibernate Validator

### Enjoy coding! 💻✨

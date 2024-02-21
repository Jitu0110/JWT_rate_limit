# Java-JWT-RateLimit-API

## Overview:

This project is a Java - Spring Boot application that exposes a secure API with the following features:

- **User Authentication:** Users can register and authenticate using Spring Security with JSON Web Tokens (JWT).
- **Database:** User data is stored in a PostgreSQL database.
- **Rate Limiting:** The API endpoint returning "Hello" is rate limited to 3 calls per user per minute, with call data stored in Redis.

## Requirements:

- Java v11 + 
- Spring Boot v3.2 🌱
- Spring Security 🔒
- JWT 🔑
- PostgreSQL 🐘
- Redis 🧪

## Getting Started:

1. **Clone the repository** 
2. **Install dependencies:** `mvn install` 
3. **Configure database connection details in `application.properties`.**
4. **Start the application:** `mvn spring-boot:run`

## API Endpoints:

- `/register`: User registration endpoint (POST) - returns JWT token on successful registration
- `/authenticate`: User authentication endpoint (POST) - returns new JWT token on successful authentication
- `/hello`: Protected API endpoint returning "Hello" (GET) - rate limited to 3 calls per user per minute




# Spring Boot Eager vs Lazy Loading Demo

This project demonstrates the difference between **EAGER** and **LAZY** fetching in JPA/Hibernate using Spring Boot (Java 17, Gradle) with an in-memory H2 database.

## Features
- **Monolithic to Microservices migration context**
- **Entities:** Author and Book
- **Endpoints:**
  - `/authors/lazy` → Shows N+1 problem with LAZY loading
  - `/authors/lazy-no-nplus` → Solves N+1 problem with fetch join
  - `/authors/eager` → Demonstrates EAGER fetching
- **Database:** In-memory H2 (`jdbc:h2:mem:eagerlazy`)
- **DTO Mapping** to avoid infinite JSON recursion

## Requirements
- Java 17
- Gradle

## How to Run
```bash
./gradlew bootRun
```

The app will start on **http://localhost:8080**.

## API Endpoints
- [http://localhost:8080/authors/lazy](http://localhost:8080/authors/lazy)
- [http://localhost:8080/authors/lazy-no-nplus](http://localhost:8080/authors/lazy-no-nplus)
- [http://localhost:8080/authors/eager](http://localhost:8080/authors/eager)

## H2 Console
Accessible at [http://localhost:8080/h2](http://localhost:8080/h2)  
Use the following:
- JDBC URL: `jdbc:h2:mem:eagerlazy`
- User: `sa`
- Password: *(leave blank)*

## Tests
Run the tests with:
```bash
./gradlew test
```

The `SmokeTest` ensures the Spring context loads properly.  
`LazyeagerApplicationTests` validates database initialization and mapping.

## Why?
This project is designed to help you understand:
- The **N+1 query problem**
- How **EAGER** vs **LAZY** fetching works
- How to fix N+1 with **fetch joins** or **EntityGraph**

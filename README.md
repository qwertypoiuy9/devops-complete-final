# Student Management System

A simple Spring Boot web application for managing college student records. This project is designed to demonstrate a CI/CD pipeline, including automated tests, Maven builds, and Docker deployment.

## Features

- Secure login with a default administrator account
- Dashboard with student and department totals
- Add, view, edit, and delete student records
- Responsive Thymeleaf pages with plain CSS
- H2 in-memory database and browser console
- Five sample students are added automatically to an empty database

## Technology stack

Java 17, Spring Boot 3, Maven, Spring Web, Thymeleaf, Spring Data JPA, H2, Spring Security, JUnit 5, and Docker.

## Run locally with Maven

Install Java 17 and Maven, then run these commands from the project directory:

```bash
mvn clean install
mvn spring-boot:run
```

Open [http://localhost:8080/login](http://localhost:8080/login) in your browser.

**Default login:** username `admin`, password `admin123`.

The H2 console is available at [http://localhost:8080/h2-console](http://localhost:8080/h2-console). Use JDBC URL `jdbc:h2:mem:studentdb`, username `sa`, and password `password`.

## Build the Docker image

```bash
docker build -t student-management-system .
```

## Run with Docker Compose

```bash
docker compose up --build
```

The application is available at [http://localhost:8080/login](http://localhost:8080/login). Stop it with `docker compose down`.

## CI/CD

Run `mvn clean install` in a CI pipeline to compile the application and run the JUnit tests. The Dockerfile builds a Java 17 application image that can be published and deployed by a pipeline such as Jenkins.

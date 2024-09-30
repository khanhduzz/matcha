# Matcha 🍃 - Microservices shopping system
A sample for learning how to build a shopping with microservices

[![product-ci](https://github.com/khanhduzz/matcha/actions/workflows/product-ci.yaml/badge.svg)](https://github.com/khanhduzz/matcha/actions/workflows/product-ci.yaml)

[![codecov](https://codecov.io/github/khanhduzz/matcha/graph/badge.svg?token=ESZ4FX0CF8)](https://codecov.io/github/khanhduzz/matcha)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=bugs)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=khanhduzz_matcha&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=khanhduzz_matcha) 



# Technologies
- Java 21
- Spring boot 3.3.3
- Swagger
- PostgreSQL
- Bootstrap
- Docker
- Sonar cloud for checking clean code.

> *_Running:_* You can run this project with Docker container
> - Run docker on your local machine.

[//]: # (> - Run `mvn clean install` to create `.jar` file)
> - Go to the project, run `docker compose pull` if you want to update images or just `docker compose up` on `terminal/command promt`, then waiting for project starting
> - The project is run on: `localhost:8086/sun/`
> - The postgres container is run on: `localhost:5432`\
>   Default user:\
>     `username: admin`\
>     `password: admin`  
> - The PgAdmin is run on: `localhost:8081`\
>   Defaul pgAdmin user:\
>     `username: admin@sun.com`\
>     `password: admin`\
>   After login to `PgAmin -> Register -> Create new -> Create postgres database`

# Current Feature
- Init the spring boot project, setup README.md, MIT license


# Architecture


# Database Modeling

# Setting Up and Running at Local

## Configuration

Include setup steps for PostgreSQL database connection, and any other necessary configurations.

1. Set up PostgreSQL:

    - Install PostgreSQL on your system.
    - Create a new PostgreSQL database for your application.
    
2. Set up environment variable:

    - Clone file **.env.sample** to the new file with name: **.env**
    - Update environment variable in file **.env**

## Run
0. Remember checkstyle
```bash
   ./mvnw checkstyle:checkstyle
```
1. Build the Project
```bash
    ./mvnw clean install  
```
2. Run the Application
```bash
    ./mvnw spring-boot:run
```
3. Note

   - Test account:
   ```bash
       email: sun@sun.com
       password: test1234
    ```
# References

## Documentation & Tools
1. **Spring Boot Documentation**:
   - [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

2. **Swagger Documentation**:
   - [Swagger OpenAPI Specification](https://swagger.io/specification/)

3. **PostgreSQL Documentation**:
   - [PostgreSQL Official Documentation](https://www.postgresql.org/docs/)

4. **Thymeleaf Documentation**:
   - [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)

5. **Bootstrap Documentation**:
   - [Bootstrap Official Documentation](https://getbootstrap.com/docs/5.3/getting-started/introduction/)

6. **jQuery Documentation**:
   - [jQuery API Documentation](https://api.jquery.com/)

7. **Docker Documentation**:
   - [Docker Documentation](https://docs.docker.com/)

8. **SonarCloud Documentation**:
   - [SonarCloud Documentation](https://sonarcloud.io/documentation/)

## Development & Deployment
1. **Maven Documentation**:
   - [Maven Project Documentation](https://maven.apache.org/guides/index.html)

2. **GitHub Actions Documentation**:
   - [GitHub Actions Documentation](https://docs.github.com/en/actions)

3. **PgAdmin Documentation**:
   - [PgAdmin Documentation](https://www.pgadmin.org/docs/)

## Best Practices & Standards
1. **Clean Code**:
   - [Clean Code by Robert C. Martin](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)

2. **Checkstyle Documentation**:
   - [Checkstyle Documentation](https://checkstyle.sourceforge.io/)

3. **MIT License**:
   - [MIT License Text](https://opensource.org/licenses/MIT)

## Additional Learning Resources
1. **Java 17 Official Documentation**:
   - [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)

2. **SonarQube Documentation**:
   - [SonarQube Documentation](https://docs.sonarqube.org/latest/)

3. **JPA & Hibernate Documentation**:
   - [Java Persistence API (JPA) Documentation](https://www.oracle.com/java/technologies/persistence-jsp.html)
   - [Hibernate ORM Documentation](https://hibernate.org/orm/documentation/)

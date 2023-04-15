#Technical Assesment

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- PostgreSQL

You will need to setup your own database or create a database with the following configuration

```
spring.datasource.url=jdbc:postgresql://localhost:5432/userV2
spring.datasource.username=postgres
spring.datasource.password="your password"
```
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.springjwt.SpringBootSecurityJwtApplication` class from your IDE.

## Postman tes


![Get All User in postman](GetAll.png.png)



For login the route will be

![Login in postman](Login.png)


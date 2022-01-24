# Springboot-with-MongoDB-Lombok-Docker

## Introduction:
 This project was developed by using Spring Boot , with Lombok integration to remove boilerplate code. MongoDB database is used here with docker container.
 
 In this project a student model is developed to store it in the mongoDB (A NoSQL database) and a single API is designed to fetch all the records store in the database.
 ```
 loclahost:8080/api/v1/students
 ```
 
 ### Following code is for StudentController class to expose the above API:
 
 ```
 package com.mongodb.practice.demo.mongodb;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents(){
        
        return studentService.getAllStudents();
    }
}
```
 
 ### Student Model
 ```
 package com.mongodb.practice.demo.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favourtieSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime createdAt;

    public Student(String firstName,
                   String lastName,
                   String email,
                   Gender gender,
                   Address address,
                   List<String> favourtieSubjects,
                   BigDecimal totalSpentInBooks,
                   LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favourtieSubjects = favourtieSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.createdAt = createdAt;
    }
}
 ```
 ### Docker
 Docker images were used to pull the mongodb database services, following is the configuration file for docker container. 
 
 ```
 ersion: '3.1'

services:

  mongo:
    image: mongo
    restart: always
    ports: ["27017:27017"]
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: example

  mongo-express:
    image: mongo-express
    restart: always
    ports: [8081:8081]
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: root
      ME_CONFIG_MONGODB_ADMINPASSWORD: example
      ME_CONFIG_MONGODB_URL: mongodb://root:example@mongo:27017/
  ```    
 
 ### Lombok
 Project Lombok is a java library that automatically plugs into our editor and build tools, spicing up our java code. 
 With few annotations we can save us from writting many lines of code. :blush: Following are some annotations which saved us not to write getters, setters and many more code portions.
 
 ```
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
```

 ### Postman
 On the client side we used Postmant to test our API.
 
 
 
 

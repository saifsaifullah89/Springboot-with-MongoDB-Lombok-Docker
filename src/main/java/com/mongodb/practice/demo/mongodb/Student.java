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

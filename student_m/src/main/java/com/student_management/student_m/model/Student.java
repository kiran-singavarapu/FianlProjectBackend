package com.student_management.student_m.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private int marks;
    private int noOfPresentDays;
    private int noOfAbsentDays;

    public Student(String firstname, String lastname, String email, int marks, int noOfPresentDays, int noOfAbsentDays) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.marks =marks;
        this.noOfPresentDays = noOfPresentDays;
        this.noOfAbsentDays =noOfAbsentDays;
    }
}

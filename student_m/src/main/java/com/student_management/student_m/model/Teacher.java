package com.student_management.student_m.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String department;

    public Teacher(String firstname, String lastname, String department,String email,String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;

    }
}

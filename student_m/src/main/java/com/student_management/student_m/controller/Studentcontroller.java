package com.student_management.student_m.controller;

import com.student_management.student_m.model.Student;
import com.student_management.student_m.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
public class Studentcontroller {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestBody  Student student)
    {
        try{
            return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id)
    {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/delete-student/{id}")
    public void deleteStudentById(@PathVariable Long id)
    {
    studentService.deleteStudentById(id);
    }

    @PutMapping("/update-student/{id}")
    public void UpdateStudentbyId(@PathVariable Long id,@RequestBody Student student)
    {
        studentService.updateStudentById(student.getId(), student);
    }
}

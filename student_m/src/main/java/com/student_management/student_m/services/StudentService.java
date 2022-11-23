package com.student_management.student_m.services;

import com.student_management.student_m.model.Student;
import com.student_management.student_m.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(Long id)
    {
        return  studentRepository.findById(id);
    }

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public void updateStudentById(Long id,Student student)
    {
        studentRepository.save(student);
    }

    public void deleteStudentById(Long id)
    {
        studentRepository.deleteById(id);
    }
}

package com.student_management.student_m.services;

import com.student_management.student_m.model.Teacher;
import com.student_management.student_m.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers()
    {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getStudentById(Long id)
    {
        return teacherRepository.findById(id);
    }

    public void updateTeacherById(Long id,Teacher teacher)
    {
        teacherRepository.save(teacher);
    }

    public Teacher addTeacher(Teacher teacher)
    {
     return   teacherRepository.save(teacher);
    }

    public void deleteTeacherById(Long id)
    {
   teacherRepository.deleteById(id);
    }
}

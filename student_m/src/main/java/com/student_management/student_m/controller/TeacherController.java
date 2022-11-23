package com.student_management.student_m.controller;

import com.student_management.student_m.Dto.Teacherlogin;
import com.student_management.student_m.model.Teacher;
import com.student_management.student_m.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

     @PostMapping("/adminlogin")
    public ResponseEntity<?> adminLogin(@RequestBody Teacherlogin t)
    {
        HashMap<String,String> res=new HashMap<>();

            if (t.getEmail().equals("admin@gmail.com") && (t.getPassword().equals("admin"))) {
                res.put("message", "admin");
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
            else {
                res.put("message","not valid credentialws");
                return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @PostMapping("/teacherlogin")
    public  ResponseEntity<?> teacherLogin(@RequestBody Teacherlogin t)
    {
        HashMap<String,String> res=new HashMap();
        if(t.getEmail().equals("teacher@gmail.com")&& (t.getPassword().equals("teacher")))
        {
            res.put("message","teacher");
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);

    }

    @PostMapping("/studentlogin")
    private ResponseEntity<?> studentLogin(@RequestBody Teacherlogin t)
    {
        HashMap<String,String> res=new HashMap<>();
        if(t.getEmail().equals("student@gmail.com")&& (t.getPassword().equals("student")))
        {
            res.put("message","student");
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);

    }

    @PostMapping("/add-teacher")
    public ResponseEntity<?> addStudent(@RequestBody Teacher teacher)
    {
        try{
            return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@GetMapping("/teacher/{id}")
    public Optional<Teacher> getTeacherbyId(@PathVariable Long id)
    {
        return teacherService.getStudentById(id);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers()
    {
     return  teacherService.getAllTeachers();
    }

    @DeleteMapping("/delete-teacher/{id}")
    public void deleteTeacherById(@PathVariable Long id)
    {
        teacherService.deleteTeacherById(id);
    }

    @PutMapping("/update-teacher/{id}")
    public void updateTeacherById(@PathVariable Long id,@RequestBody Teacher teacher)
    {
      teacherService.updateTeacherById(teacher.getId(), teacher);
    }
}

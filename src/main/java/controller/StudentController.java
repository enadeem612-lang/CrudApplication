package com.example.crudapplication.controller;

import com.example.crudapplication.entity.Student;
import com.example.crudapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,@RequestBody Student student){
        return service.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.deleteStudent(id);
        return "Student Deleted Successfully";
    }

}

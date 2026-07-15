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
    private StudentService studentService;

    // Add Student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // Get All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Update Student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    // Search Student By Name
    @GetMapping("/search/name/{name}")
    public List<Student> searchByName(@PathVariable String name) {
        return studentService.searchByName(name);
    }

    // Search Student By Department
    @GetMapping("/search/department/{department}")
    public List<Student> searchByDepartment(@PathVariable String department) {
        return studentService.searchByDepartment(department);
    }

    // Search Student By Roll Number
    @GetMapping("/search/rollno/{rollNo}")
    public Student searchByRollNo(@PathVariable String rollNo) {
        return studentService.searchByRollNo(rollNo);
    }

}
package com.example.crudapplication.service;

import com.example.crudapplication.entity.Student;
import com.example.crudapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Add Student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student By ID
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    // Update Student
    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setRollNo(updatedStudent.getRollNo());
            student.setEmail(updatedStudent.getEmail());
            student.setDepartment(updatedStudent.getDepartment());

            return studentRepository.save(student);
        }

        return null;
    }

    // Delete Student
    public String deleteStudent(Long id) {

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student Deleted Successfully";
        }

        return "Student Not Found";
    }

    // Search By Name
    public List<Student> searchByName(String name) {
        return studentRepository.findByName(name);
    }

    // Search By Department
    public List<Student> searchByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    // Search By Roll Number
    public Student searchByRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo);
    }

}
package com.example.crudapplication.repository;

import com.example.crudapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Search Student by Name
    List<Student> findByName(String name);

    // Search Student by Department
    List<Student> findByDepartment(String department);

    // Search Student by Roll Number
    Student findByRollNo(String rollNo);

}
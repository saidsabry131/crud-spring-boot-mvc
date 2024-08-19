package org.example.studentmanagement.service;

import org.example.studentmanagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    List<Student> getALL();
    Student getStudent(Long id);

    void saveStudent(Student student);

    Student deleteStudent(Long id);

    Student edit(Student student);

}

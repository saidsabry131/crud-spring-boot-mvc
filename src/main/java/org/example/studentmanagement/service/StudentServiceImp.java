package org.example.studentmanagement.service;

import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepo studentRepo;
    @Autowired
    public StudentServiceImp(StudentRepo studentRepo)
    {
       this.studentRepo=studentRepo;
    }
    @Override
    public List<Student> getALL() {

       return studentRepo.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student deleteStudent(Long id) {
        // Find the student by ID
        Optional<Student> optionalStudent = studentRepo.findById(id);

        // Check if the student exists
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.println("Deleting student with ID: " + id + " - " + student);

            // Delete the student
            studentRepo.deleteById(id);

            return student;
        } else {
            System.out.println("Student with ID: " + id + " not found.");
            return null;
        }
    }

    @Override
    public Student edit(Student student) {
        return studentRepo.save(student);
    }

}

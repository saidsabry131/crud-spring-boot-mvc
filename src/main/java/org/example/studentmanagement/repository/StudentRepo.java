package org.example.studentmanagement.repository;

import org.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository  // is optional because SimpleJpaRepository that implement jpaRepository annotated with it
public interface StudentRepo extends JpaRepository<Student,Long> {
}

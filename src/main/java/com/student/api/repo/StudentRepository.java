package com.student.api.repo;

import com.student.api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student>findByName(String studentName);
    @Query(value = "select * from student where email = ?1",nativeQuery = true)
        Student searchByEmail(String studentEmail);
}

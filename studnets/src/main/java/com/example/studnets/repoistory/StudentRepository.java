package com.example.studnets.repoistory;

import com.example.studnets.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByName(String name);
    List<Student> findAllByAgeGreaterThanEqual(Integer age);
    @Query("SELECT s FROM Student s WHERE s.major=?1 and s.age=?2")
    Student lookForStudent(String major,Integer age);
}

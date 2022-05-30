package com.example.studnets.service;

import com.example.studnets.model.Student;
import com.example.studnets.repoistory.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private  final StudentRepository studentRepository;

    public List<Student> getStudents() {
    return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentByAge(Integer age) {
        return studentRepository.findAllByAgeGreaterThanEqual(age);
    }

    public Student getStudentByAgeAndMajor(Integer age, String major) {
        return studentRepository.lookForStudent(major,age);
    }
}

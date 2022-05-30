package com.example.studnets.controller;

import com.example.studnets.model.Student;
import com.example.studnets.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class StudentController {

    private  final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @GetMapping("/name")
    public ResponseEntity<Student> getStudentByName(@RequestParam String name){
        return ResponseEntity.status(200).body(studentService.getStudentByName(name));
    }

    @GetMapping("/age")
    public ResponseEntity<List<Student>> getStudentByAge(@RequestParam Integer age){
        return ResponseEntity.status(200).body(studentService.getStudentByAge(age));
    }

    @GetMapping("/age-major")
    public ResponseEntity<Student> getStudentByAgeAndMajor(@RequestParam Integer age,@RequestParam String major){
        return ResponseEntity.status(200).body(studentService.getStudentByAgeAndMajor(age,major));
    }
    @GetMapping("/age-major-name")
    public ResponseEntity<Student> getStudentByAgeAndMajorAndName(@RequestParam Integer age,@RequestParam String major,@RequestParam String name){
        return ResponseEntity.status(200).body(studentService.getStudentByAgeAndMajor(age,major));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id){

        return ResponseEntity.status(200).body(studentService.getStudent(id));
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added !");
    }

}

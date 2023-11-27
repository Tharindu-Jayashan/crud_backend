package com.example.crud_backend.control;

import com.example.crud_backend.entity.Student;
import com.example.crud_backend.repository.StudentRepository;
import com.example.crud_backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController

public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/Students")
    public List<Student> findAllStudents(){
        return service.getStudents();
    }

    @GetMapping("/studentById/{id}")
    public Student findStudentById(@PathVariable int id){
        return service.getStudentById(id);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        return service.deleteStudent(id);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

}

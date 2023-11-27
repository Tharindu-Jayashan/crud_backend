package com.example.crud_backend.service;

import com.example.crud_backend.entity.Student;
import com.example.crud_backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public List<Student> getStudents(){
        return repository.findAll();
    }

    public Student getStudentById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteStudent(int id){
        repository.deleteById(id);
        return "product removed || "+id;
    }

    public Student updateStudent(Student student){
        Student existingStudent = repository.findById(student.getId()).orElse(null);

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setAddress(student.getAddress());

        return repository.save(existingStudent);
    }


}

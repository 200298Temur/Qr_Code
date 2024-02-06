package com.temur.qrcode.service;

import com.temur.qrcode.model.Student;
import com.temur.qrcode.repositoriy.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAll(){
        return  studentRepository.findAll();
    }

    public  Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudent(Long id){
        return studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student not found"));
    }

}

package com.temur.qrcode.control;

import com.google.zxing.WriterException;
import com.temur.qrcode.model.Student;
import com.temur.qrcode.service.StudentService;
import com.temur.qrcode.utils.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public  class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() throws IOException, WriterException {
        List<Student> students=studentService.getAll();
        if(students.size()!=0){
            for(Student student:students){
                QRCodeGenerator.generateQRCode(student);
            }
        }
        return ResponseEntity.ok(studentService.getAll());
    }
    @PostMapping()
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id){
        return studentService.findStudent(id);
    }



}

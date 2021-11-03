package com.example.student.api;

import com.example.student.model.Student;
import com.example.student.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/student")
@RestController
public class Studentcontrollers {
    private final StudentServices studentServices;

    @Autowired
    public Studentcontrollers(StudentServices studentServices) {
        this.studentServices = studentServices;
    }
    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentServices.addStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return studentServices.getAllStudent();
    }
    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("mathId") UUID matId){
        return studentServices.getStudentById(matId)
                .orElse(null);
    }
    @DeleteMapping(path = "{matId}")
    public void deleteStudentById(@PathVariable("matId") UUID matId){
        studentServices.studentDelete(matId);
    }
    @PutMapping(path = "{matId}")
    public void updateStudent(@PathVariable UUID matId, @RequestBody Student newStudent){
        studentServices.updateStudent(matId, newStudent);
    }
}
//fffffffaa
package com.example.student.service;

import com.example.student.dao.StudentDao;
import com.example.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServices {
    private final StudentDao studentDao;

    @Autowired
    public StudentServices(@Qualifier("studentdao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudent(){
        return studentDao.selectAllStudent();
    }

    public Optional<Student> getStudentById(UUID matId){
        return studentDao.selectPersonById(matId);
    }
    public int studentDelete(UUID matId){
        return studentDao.deleteStudentById(matId);
    }
    public int updateStudent(UUID matId, Student newStudent){
        return updateStudent(matId, newStudent);
    }
}

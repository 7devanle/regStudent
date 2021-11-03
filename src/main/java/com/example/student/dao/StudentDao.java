package com.example.student.dao;

import com.example.student.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    int insertStudent(Student student, UUID matId);

    default int insertStudent(Student student) {
        UUID matId = UUID.randomUUID();
        return insertStudent(student, matId);
    }
    List<Student> selectAllStudent();
    Optional<Student> selectPersonById(UUID matId);

    int deleteStudentById(UUID matId);
    int updateStudentById(UUID matId, Student student);

}

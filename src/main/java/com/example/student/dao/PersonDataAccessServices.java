package com.example.student.dao;

import com.example.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("studentdao")
public class PersonDataAccessServices implements StudentDao{

    private static List<Student> DB = new ArrayList<>();

    @Override
    public int insertStudent(Student student, UUID id) {
        DB.add(new Student(student.getName(), student.getLevel()));
        return 1;
    }

    @Override
    public List<Student> selectAllStudent() {
        return DB;
    }

    @Override
    public Optional<Student> selectPersonById(UUID matId) {
        return DB.stream()
                .filter(student -> student.getMatId().equals(matId))
                .findFirst();
    }

    @Override
    public int deleteStudentById(UUID matId) {
        Optional<Student> studentMaybe = selectPersonById(matId);
        if(studentMaybe.isEmpty()){
            return 0;
        }
        DB.remove(studentMaybe);
        return 1;
    }

    @Override
    public int updateStudentById(UUID matId, Student student) {
        return selectPersonById(matId)
                .map(studentx -> {
                    int indexOfStudentToDelete = DB.indexOf(studentx);
                    if (indexOfStudentToDelete >= 0){
                        DB.set(indexOfStudentToDelete, studentx);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}

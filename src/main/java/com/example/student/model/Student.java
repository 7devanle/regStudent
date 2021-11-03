package com.example.student.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Student {
    private final UUID matId;
    private final String name;
    private final String level;
    private List<String> courses;

    public Student(@JsonProperty("id") UUID matId
            , @JsonProperty("name") String name
            , @JsonProperty("level") String level) {
        this.matId = matId;
        this.name = name;
        this.level = level;
        this.courses.add("Mathematics");
        this.courses.add("English");
        this.courses.add("General Paper");
    }
    public Student(@JsonProperty("Name") String name
            , @JsonProperty("level") String level) {
        this.matId = UUID.randomUUID();
        this.name = name;
        this.level = level;
        this.courses.add("Mathematics");
        this.courses.add("English");
        this.courses.add("General Paper");
    }

    public UUID getMatId() {
        return matId;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void addCourse(String course){
        this.courses.add(course);
    }

}

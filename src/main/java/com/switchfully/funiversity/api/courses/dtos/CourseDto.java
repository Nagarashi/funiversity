package com.switchfully.funiversity.api.courses.dtos;

import com.switchfully.funiversity.api.professors.dtos.ProfessorDto;

public class CourseDto {

    private String id;
    private String name;
    private int studyPoints;
    private ProfessorDto professor;

    public String getId() {
        return id;
    }

    public CourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public CourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public ProfessorDto getProfessor() {
        return professor;
    }

    public CourseDto setProfessor(ProfessorDto professor) {
        this.professor = professor;
        return this;
    }
}

package com.switchfully.funiversity.api.courses.dtos;

import com.switchfully.funiversity.api.professors.dtos.ProfessorDto;

public class UpdateCourseDto {

    private String name;
    private int studyPoints;
    private ProfessorDto professor;

    public String getName() {
        return name;
    }

    public UpdateCourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public UpdateCourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public ProfessorDto getProfessor() {
        return professor;
    }

    public UpdateCourseDto setProfessor(ProfessorDto professor) {
        this.professor = professor;
        return this;
    }
}

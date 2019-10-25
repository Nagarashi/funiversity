package com.switchfully.funiversity.domain.courses;

import com.switchfully.funiversity.domain.professors.Professor;

import java.util.UUID;

public class Course {

    private final static int MIN_STUDY_POINTS = 1;
    private final static int MAX_STUDY_POINTS = 6;

    private final String id;
    private String name;
    private int studyPoints;
    private Professor professor;


    public Course(String name, int studyPoints, Professor professor) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        setStudyPoints(studyPoints);
        this.professor = professor;
    }

    public Course(String id, String name, int studyPoints, Professor professor) {
        this.id = id;
        this.name = name;
        setStudyPoints(studyPoints);
        this.professor = professor;
    }

    private void setStudyPoints(int studyPoints) {
        if (studyPoints < 1 || studyPoints > 6) throw new IllegalArgumentException("Study Points are minimum 1 and maximum 6");
        this.studyPoints = studyPoints;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public Professor getProfessor() {
        return professor;
    }
}

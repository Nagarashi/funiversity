package com.switchfully.funiversity.api;

import com.switchfully.funiversity.api.courses.dtos.CourseDto;
import com.switchfully.funiversity.api.professors.dtos.ProfessorDto;
import com.switchfully.funiversity.domain.courses.Course;
import com.switchfully.funiversity.domain.professors.Professor;
import org.springframework.stereotype.Component;

@Component
public class FuniversityMapper {

    public ProfessorDto mapToProfessorDto(Professor professor) {
        com.switchfully.funiversity.api.professors.dtos.ProfessorDto professorDto = new com.switchfully.funiversity.api.professors.dtos.ProfessorDto();
        professorDto.setId(professor.getId());
        professorDto.setFirstName(professor.getFirstName());
        professorDto.setLastName(professor.getLastName());

        return professorDto;
    }

    public CourseDto mapToCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setStudyPoints(course.getStudyPoints());
        courseDto.setProfessor(mapToProfessorDto(course.getProfessor()));

        return courseDto;
    }
}

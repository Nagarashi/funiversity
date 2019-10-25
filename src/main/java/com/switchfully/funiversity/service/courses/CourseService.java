package com.switchfully.funiversity.service.courses;

import com.switchfully.funiversity.api.courses.CourseController;
import com.switchfully.funiversity.api.courses.dtos.CreateCourseDto;
import com.switchfully.funiversity.api.courses.dtos.UpdateCourseDto;
import com.switchfully.funiversity.domain.courses.CourseDao;
import com.switchfully.funiversity.domain.professors.Professor;
import com.switchfully.funiversity.domain.professors.ProfessorDao;
import com.switchfully.funiversity.domain.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Component
public class CourseService {

    private CourseDao courseDao;
    private ProfessorDao professorDao;

    @Autowired
    public CourseService(CourseDao courseDao, ProfessorDao professorDao) {
        this.courseDao = courseDao;
        this.professorDao = professorDao;
    }

    public Collection<Course> getAllCourses() {
        return courseDao.getAll();
    }

    public Collection<Course> getAllCoursesByPoints(int studyPoints) {
        return courseDao.getAllByPoints(studyPoints);
    }

    public Course get(String id) {
        return courseDao.getById(id);
    }

    public Course saveCourse (Course course) {
        return courseDao.save(course);
    }

    public void removeCourse (String id) {
        courseDao.remove(id);
    }

    public Course createCourse(CreateCourseDto createCourseDto) {
        return new Course(createCourseDto.getName(), createCourseDto.getStudyPoints(),
                professorDao.getById(createCourseDto.getProfessor().getId()));
    }

    public Course updateCourse(String id, UpdateCourseDto updateCourseDto) {
        return new Course(get(id).getId(), updateCourseDto.getName(), updateCourseDto.getStudyPoints(),
                professorDao.getById(updateCourseDto.getProfessor().getId()));
    }
}

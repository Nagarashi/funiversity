package com.switchfully.funiversity.api.courses;

import com.switchfully.funiversity.api.FuniversityMapper;
import com.switchfully.funiversity.api.courses.dtos.CourseDto;
import com.switchfully.funiversity.api.courses.dtos.CreateCourseDto;
import com.switchfully.funiversity.api.courses.dtos.UpdateCourseDto;
import com.switchfully.funiversity.service.courses.CourseService;
import com.switchfully.funiversity.service.professors.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private CourseService courseService;
    private ProfessorService professorService;
    private FuniversityMapper funiversityMapper;

    @Autowired
    public CourseController(CourseService courseService, FuniversityMapper funiversityMapper) {
        this.courseService = courseService;
        this.funiversityMapper = funiversityMapper;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getCourses(@RequestParam (required = false) Integer studyPoints) {
        if (studyPoints != null) { return courseService.getAllCoursesByPoints(studyPoints).stream()
                    .map(course -> funiversityMapper.mapToCourseDto(course))
                    .collect(Collectors.toList());
        } else { return courseService.getAllCourses().stream()
                    .map(course -> funiversityMapper.mapToCourseDto(course))
                    .collect(Collectors.toList());
        }
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto getCourse(@PathVariable("id") String id) {
        return funiversityMapper.mapToCourseDto(courseService.get(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto createCourse(@RequestBody CreateCourseDto createCourseDto) {
        return funiversityMapper.mapToCourseDto(
                courseService.saveCourse(
                        courseService.createCourse(createCourseDto)));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto modifyCourse(@PathVariable("id") String id, @RequestBody UpdateCourseDto updateCourseDto) {
        return funiversityMapper.mapToCourseDto(
                courseService.saveCourse(
                        courseService.updateCourse(id, updateCourseDto)));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.CONTINUE)
    public void deleteCourse(@PathVariable("id") String id) {
        courseService.removeCourse(id);
    }
}

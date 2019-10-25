package com.switchfully.funiversity.domain.courses;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class CourseRepository implements CourseDao {

    private final ConcurrentHashMap<String, Course> courseById;

    public CourseRepository() {
        courseById = new ConcurrentHashMap<>();
    }

    @Override
    public Course save(Course course) {
        courseById.put(course.getId(), course);
        return course;
    }

    @Override
    public Course getById(String id) throws IllegalArgumentException {
        var foundCourse = courseById.get(id);
        if (foundCourse == null) {
            throw new IllegalArgumentException("No Professor could be found for id " + id);
        }
        return foundCourse;
    }

    @Override
    public Collection<Course> getAll() {
        return courseById.values();
    }

    @Override
    public Collection<Course> getAllByPoints(int studyPoints) {
        return courseById.values().stream()
                .filter(course -> course.getStudyPoints() == studyPoints)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(String id) {
        courseById.remove(id);
    }
}


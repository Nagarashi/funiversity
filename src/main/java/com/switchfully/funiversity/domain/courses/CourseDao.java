package com.switchfully.funiversity.domain.courses;

import java.util.Collection;

public interface CourseDao {

    Course save(Course course);

    Course getById(String id) throws IllegalArgumentException;

    Collection<Course> getAll();

    Collection<Course> getAllByPoints(int studyPoints);

    void remove(String id);
}

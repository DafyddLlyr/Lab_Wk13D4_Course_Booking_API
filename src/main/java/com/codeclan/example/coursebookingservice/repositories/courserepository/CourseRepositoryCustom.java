package com.codeclan.example.coursebookingservice.repositories.courserepository;

import com.codeclan.example.coursebookingservice.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {
    public List<Course> getCourseByCustomer(Long id);
}

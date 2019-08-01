package com.codeclan.example.coursebookingservice.repositories.courserepository;

import com.codeclan.example.coursebookingservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom{
    public List<Course> findCourseByRating(int rating);
    public List<Course> findCourseByBookingsCustomerId(Long id);
}

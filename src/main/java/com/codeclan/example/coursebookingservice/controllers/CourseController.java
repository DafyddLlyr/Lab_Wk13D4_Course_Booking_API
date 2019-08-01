package com.codeclan.example.coursebookingservice.controllers;

import com.codeclan.example.coursebookingservice.models.Course;
import com.codeclan.example.coursebookingservice.repositories.courserepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/rating/{rating}")
    public List<Course> getCoursesByRating(@PathVariable int rating){
        return courseRepository.findCourseByRating(rating);
    }

    @GetMapping("/customer/{id}")
    public List<Course> getCourseBycustomer(@PathVariable Long id){
//        return  courseRepository.getCourseByCustomer(id);
        return courseRepository.findCourseByBookingsCustomerId(id);
    }

}

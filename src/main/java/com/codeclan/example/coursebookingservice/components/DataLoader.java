package com.codeclan.example.coursebookingservice.components;

import com.codeclan.example.coursebookingservice.models.Booking;
import com.codeclan.example.coursebookingservice.models.Course;
import com.codeclan.example.coursebookingservice.models.Customer;
import com.codeclan.example.coursebookingservice.repositories.bookingrepository.BookingRepository;
import com.codeclan.example.coursebookingservice.repositories.courserepository.CourseRepository;
import com.codeclan.example.coursebookingservice.repositories.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Customer customer1 = new Customer("Dafydd", "Glasgow", 31);
        customerRepository.save(customer1);

        Course course1 = new Course("Python", "Glasgow", 5);
        courseRepository.save(course1);

        Booking booking1 = new Booking("01-08-19", course1, customer1);
        bookingRepository.save(booking1);

    }
}

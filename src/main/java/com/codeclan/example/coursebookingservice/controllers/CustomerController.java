package com.codeclan.example.coursebookingservice.controllers;

import com.codeclan.example.coursebookingservice.models.Customer;
import com.codeclan.example.coursebookingservice.repositories.bookingrepository.BookingRepository;
import com.codeclan.example.coursebookingservice.repositories.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/course/{id}")
    public List<Customer> getCustomerByCourse(@PathVariable Long id) {
        return customerRepository.findCustomersByBookingsCourseId(id);
//        return customerRepository.findCustomersByCourse(id);
    }

    @GetMapping("/course/{id}/town/{town}")
    public List<Customer> findCustomerByCourseIDAndTown(@PathVariable Long id, @PathVariable String town) {
        return customerRepository.findCustomersByBookingsCourseIdAndTownIgnoreCase(id, town);
//        return customerRepository.findCustomerByCourseIDAndTown(id, town);
    }

    @GetMapping("/course/{id}/town/{town}/olderthan/{age}")
    public List<Customer> findCustomerByCourseIDTownAndAge(@PathVariable Long id, @PathVariable String town, @PathVariable int age){
        return customerRepository.findCustomersByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(id, town, age);
//        return customerRepository.findCustomerByCourseIDTownAndAge(id, town, age);
    }

}

package com.codeclan.example.coursebookingservice.repositories.customerrepository;

import com.codeclan.example.coursebookingservice.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> findCustomersByCourse(Long id);

    List<Customer> findCustomerByCourseIDAndTown(Long id, String town);

    List<Customer> findCustomerByCourseIDTownAndAge(Long id, String town, int age);
}

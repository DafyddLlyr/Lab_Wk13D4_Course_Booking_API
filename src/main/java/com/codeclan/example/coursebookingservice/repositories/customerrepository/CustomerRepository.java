package com.codeclan.example.coursebookingservice.repositories.customerrepository;

import com.codeclan.example.coursebookingservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

    public List<Customer> findCustomersByBookingsCourseId(Long Id);

    public List<Customer> findCustomersByBookingsCourseIdAndTownIgnoreCase(Long id, String town);

    public List<Customer> findCustomersByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(Long id, String town, int age);

}

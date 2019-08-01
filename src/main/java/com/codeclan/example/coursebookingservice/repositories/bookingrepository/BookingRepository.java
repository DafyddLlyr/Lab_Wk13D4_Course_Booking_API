package com.codeclan.example.coursebookingservice.repositories.bookingrepository;

import com.codeclan.example.coursebookingservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}

package com.codeclan.example.coursebookingservice.repositories.bookingrepository;

import com.codeclan.example.coursebookingservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    public List<Booking> findBookingByDate(String date);
}

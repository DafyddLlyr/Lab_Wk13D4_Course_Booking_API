package com.codeclan.example.coursebookingservice.controllers;

import com.codeclan.example.coursebookingservice.models.Booking;
import com.codeclan.example.coursebookingservice.repositories.bookingrepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController  {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/date/{date}")
    public List<Booking> getBookingsByDate(@PathVariable String date){
        return bookingRepository.findBookingByDate(date);
    }

}

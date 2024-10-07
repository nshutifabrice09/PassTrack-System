package com.passtrack.fullstack_backend.controller;


import com.passtrack.fullstack_backend.exception.BookingNotFoundException;
import com.passtrack.fullstack_backend.model.Booking;
import com.passtrack.fullstack_backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/booking")
    Booking newBooking(@RequestBody Booking newBooking){
        return bookingRepository.save(newBooking);
    }

    @GetMapping("/bookings")
    List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @GetMapping("/booking/{bookingId}")
    Booking getBookingById(@PathVariable Long bookingId){
        return bookingRepository.findById(bookingId)
                .orElseThrow(()->new BookingNotFoundException(bookingId));
    }

    @PutMapping("/booking/{bookingId}")
    Booking updateBooking (@RequestBody Booking newBooking, @PathVariable Long bookingId){
        return bookingRepository.findById(bookingId)
                .map(booking -> {
                    booking.setBusId(newBooking.getBusId());
                    booking.setUserId(newBooking.getUserId());
                    return bookingRepository.save(booking);
                }).orElseThrow(()->new BookingNotFoundException(bookingId));
    }


    @DeleteMapping("/bookings/{bookingId}")
    String deleteBooking (@PathVariable Long bookingId){
        if(!bookingRepository.existsById(bookingId)){
            throw new BookingNotFoundException(bookingId);
        }
        bookingRepository.deleteById(bookingId);
        return "Booking with id "+bookingId+" has been deleted successfully.";
    }
}

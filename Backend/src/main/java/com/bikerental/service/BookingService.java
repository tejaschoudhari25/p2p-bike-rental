package com.bikerental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.dto.request.BookingRequest;
import com.bikerental.entity.Booking;
import com.bikerental.repository.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(BookingRequest request){
        Booking booking = new Booking(
            request.getUserId(),
            request.getBikeId(),
            request.getStartDate(),
            request.getEndDate(),
            request.getStatus()
        );
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id){
        return bookingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No Booking Found"));
    }

    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Long id, BookingRequest request){
        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Invalid id"));

        booking.setStartDate(request.getStartDate());
        booking.setEndDate(request.getEndDate());
        booking.setStatus(request.getStatus());

        return bookingRepository.save(booking);
    }
}

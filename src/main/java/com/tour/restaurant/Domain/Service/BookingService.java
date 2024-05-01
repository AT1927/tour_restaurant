package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.Domain.Repository.BookingRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepositoryDomain bookingRepository;

    @Autowired
    public BookingService(BookingRepositoryDomain bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<BookingDTO> getAllBookings() {
        List<BookingDTO> bookings = bookingRepository.getAll();
        return new ArrayList<>(bookings);
    }

    public Optional<BookingDTO> getBookingById(Long id) {
        return bookingRepository.getById(id);
    }

    public BookingDTO save (BookingDTO bookingDTO){
        return bookingRepository.save(bookingDTO);
    }

    public boolean delete(Long id){
        if (getBookingById(id).isPresent()) {
            bookingRepository.deleteByID(id);
            return true;
        }
        return false;
    };


}
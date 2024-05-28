package com.tour.restaurant.infraestructure.Repositories;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.Domain.Repository.BookingRepositoryDomain;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Mapper.BookingMapper;
import com.tour.restaurant.infraestructure.Repositories.Crud.BookingCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public  class BookingRepository implements BookingRepositoryDomain {

    @Autowired
    public BookingCrudRepository bookingCrudRepository;

    @Autowired
    public BookingMapper bookingMapper;


    @Override
    public List<BookingDTO> getAll() {
        List<Booking> bookings = (List<Booking>) bookingCrudRepository.findAll();
        return bookingMapper.toBookings(bookings);

    }



    @Override
    public List<BookingDTO> getActiveBookings() {
    List<Booking> bookings = (List<Booking>) bookingCrudRepository.findAll();
    return bookingMapper.toBookings(bookings.stream()
        .filter(Booking::getStatus)
        .collect(Collectors.toList()));
}

    @Override
    public Optional<BookingDTO> getById(long id) {
        Optional<Booking> booking = bookingCrudRepository.findById(id);
        return bookingMapper.toBookingsOptional(booking);
    }


    @Override
    public BookingDTO save(BookingDTO BookingDto) {
        Booking booking = bookingMapper.toBooking(BookingDto);
        if (booking.getCreatedAt() == null) {
            booking.setCreatedAt(java.time.LocalDateTime.now());
        }
        return bookingMapper.toBookingDTO(bookingCrudRepository.save(booking));
    }

    @Override
    public void deleteByID(long id) {
        bookingCrudRepository.deleteById(id);

    }



}

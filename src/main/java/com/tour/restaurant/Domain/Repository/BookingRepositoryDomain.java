package com.tour.restaurant.Domain.Repository;


import com.tour.restaurant.Domain.DTO.BookingDTO;
import org.springframework.stereotype.Repository;
import com.tour.restaurant.infraestructure.Entities.Booking;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookingRepositoryDomain {

    List<BookingDTO> getAll();


    Optional<BookingDTO> getById(long id);
    BookingDTO save(BookingDTO Booking);
    void deleteByID(long id);


}


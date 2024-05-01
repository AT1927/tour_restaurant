package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component; // Importa esta clase

import java.util.List;
import java.util.Optional;

@Mapper
@Component // Añade esta anotación
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "restaurant.id", target = "restaurantId")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)


    Booking toBooking(BookingDTO bookingDTO);
    BookingDTO toBookingDTO(Booking booking);
    List<BookingDTO> toBookings(List<Booking> bookings);

    default Optional<BookingDTO> toBookingsOptional(Optional<Booking> booking ){
        return  booking.map(this::toBookingDTO);
    }
}

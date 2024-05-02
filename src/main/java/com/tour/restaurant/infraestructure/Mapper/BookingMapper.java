package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component; // Importa esta clase

import java.util.List;
import java.util.Optional;

@Component // Añade esta anotación
@Mapper(componentModel = "spring", uses = {RestaurantMapper.class, TableFoodMapper.class})
public interface BookingMapper {
    @Mappings({
            @Mapping(source = "restaurant_id", target = "restaurantId"),
            @Mapping(source = "number_customer", target = "numberCustomer"),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })


    Booking toBooking(BookingDTO bookingDTO);
    BookingDTO toBookingDTO(Booking booking);
    List<BookingDTO> toBookings(List<Booking> bookings);

    default Optional<BookingDTO> toBookingsOptional(Optional<Booking> booking ){
        return  booking.map(this::toBookingDTO);
    }
}

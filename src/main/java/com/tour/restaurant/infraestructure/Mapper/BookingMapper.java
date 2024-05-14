package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;


import java.util.List;
import java.util.Optional;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mappings({
            @Mapping(source = "id", target ="id"),
            @Mapping(source = "numberOfPeople", target ="numberOfPeople"),
            @Mapping(source = "date", target ="date"),
            @Mapping(source = "food", target ="food"),
            @Mapping(source = "status", target ="status"),
            @Mapping(source = "statusPayment", target ="statusPayment"),
            @Mapping(source = "idRestaurant", target ="idRestaurant"),
            @Mapping(source = "idTableFood", target ="idTableFood"),

    })
    BookingDTO toBookingDTO(Booking booking);

    List<BookingDTO> toBookings(List<Booking> bookings);


    default Optional<BookingDTO> toBookingsOptional(Optional<Booking> booking ){
        return  booking.map(this::toBookingDTO);
    }
    @InheritInverseConfiguration
    Booking toBooking(BookingDTO bookingDTO);



}

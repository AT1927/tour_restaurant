package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import org.mapstruct.*;


import java.util.List;
import java.util.Optional;


@Mapper(componentModel = "spring" )
public interface BookingMapper {
    @Mappings({
            @Mapping(source = "id", target ="id"),
            @Mapping(source = "numberOfPeople", target ="numberOfPeople"),
            @Mapping(source = "date", target ="date"),
            @Mapping(source = "food", target ="food"),
            @Mapping(source = "status", target ="status"),
            @Mapping(source = "statusPayment", target ="statusPayment"),
            @Mapping(source = "restaurant.id", target ="idRestaurant"),
            @Mapping(source = "tableFood.id", target ="idTableFood"),
            @Mapping(target = "created_at", ignore = true),
            @Mapping(target = "updated_at", ignore = true),
    })
    BookingDTO toBookingDTO(Booking booking);

    List<BookingDTO> toBookings(List<Booking> bookings);


    default Optional<BookingDTO> toBookingsOptional(Optional<Booking> booking ){
        return  booking.map(this::toBookingDTO);
    }
    @InheritInverseConfiguration
    Booking toBooking(BookingDTO bookingDTO);



}

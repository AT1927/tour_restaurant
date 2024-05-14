package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    @Mappings({
            @Mapping(source = "id", target ="id"),
            @Mapping(source = "name", target ="name"),
            @Mapping(source = "description", target ="description"),
            @Mapping(source = "address", target ="address"),
            @Mapping(source = "schedule", target ="schedule"),
            @Mapping(source = "type", target ="type"),
    })

    RestaurantDTO toRestaurantDTO(Restaurant restaurant);
    List<RestaurantDTO> toRestaurantsDTO(List<Restaurant> restaurants);
    default Optional<RestaurantDTO> toRestaurantsOptional(Optional<Restaurant> restaurant ){
        return  restaurant.map(this::toRestaurantDTO);
    }
    @InheritInverseConfiguration
    Restaurant toRestaurant(RestaurantDTO restaurantDTO);


}

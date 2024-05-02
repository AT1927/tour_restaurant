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
@Component
@Mapper(componentModel = "spring", uses = {BookingMapper.class, TableFoodMapper.class})
public interface RestaurantMapper {
    @Mappings({
            @Mapping(source = "restaurant_id", target = "restaurantId"),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })


    Restaurant toRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO toRestaurantDTO(Restaurant restaurant);
    List<RestaurantDTO> toRestaurants(List<Restaurant> restaurantes);
    @InheritInverseConfiguration
    Restaurant toRestaurante(Restaurant restaurant);
    List<RestaurantDTO> toRestaurantsDTO(List<RestaurantDTO> restaurantes);
    Optional<Restaurant> toRestaurantsOptional(Optional<Restaurant> restaurant);
}

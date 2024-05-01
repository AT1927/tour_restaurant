package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {RestaurantMapper.class})
public interface RestaurantMapper {

    @Mapping(source = "restaurant.id", target = "restaurantId")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)

    Restaurant toRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO toRestaurantDTO(Restaurant restaurant);
    List<RestaurantDTO> toRestaurants(List<Restaurant> restaurantes);
    /*default Optional<RestaurantDTO> toRestaurantsOptional(Optional<RestaurantDTO> restaurant ){
        return  restaurant.map(this::toRestaurantDTO);
    }*/
    @InheritInverseConfiguration
    Restaurant toRestaurante(Restaurant restaurant);

    List<RestaurantDTO> toRestaurantsDTO(List<RestaurantDTO> restaurantes);

    Optional<Restaurant> toRestaurantsOptional(Optional<Restaurant> restaurant);
}

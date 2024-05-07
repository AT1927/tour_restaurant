package com.tour.restaurant.Domain.Repository;
import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepositoryDomain {
    
    List<RestaurantDTO> getAll();
    List<Restaurant> getByRestaurant(Restaurant restaurant);
    Optional<Restaurant> getById(long id);
    Optional<RestaurantDTO> getById(long id);
    Restaurant save(Restaurant restaurant);
    RestaurantDTO save(RestaurantDTO restaurantDTO);
    void deleteByID(long id);

}

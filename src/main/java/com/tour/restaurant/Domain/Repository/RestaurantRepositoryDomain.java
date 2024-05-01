package com.tour.restaurant.Domain.Repository;
import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepositoryDomain {
    // Aquí puedes agregar métodos adicionales si necesitas consultas personalizadas
    List<RestaurantDTO> getAll();
    List<Restaurant> getByRestaurant(Restaurant restaurant);
    Optional<Restaurant> getById(long id);
    Restaurant save(Restaurant restaurant);
    RestaurantDTO save(RestaurantDTO restaurantDTO);

    void deleteByID(long id);

}

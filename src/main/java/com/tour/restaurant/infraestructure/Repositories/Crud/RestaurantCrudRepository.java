package com.tour.restaurant.infraestructure.Repositories.Crud;
import com.tour.restaurant.infraestructure.Entities.*;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantCrudRepository extends CrudRepository<Restaurant, Long> {
}

package com.tour.restaurant.infraestructure.Repositories.Crud;

import com.tour.restaurant.infraestructure.Entities.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantCrudRepository extends CrudRepository<Restaurant, Long> {
}

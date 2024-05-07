package com.tour.restaurant.infraestructure.Repositories;
import com.tour.restaurant.Domain.Repository.RestaurantRepositoryDomain;
import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.infraestructure.Mapper.RestaurantMapper;
import com.tour.restaurant.infraestructure.Repositories.Crud.RestaurantCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public abstract class RestaurantRepository implements RestaurantRepositoryDomain {
    @Autowired
    public RestaurantCrudRepository restaurantRepo;
    @Autowired
    public RestaurantMapper mapper;

    @Override
    public List<RestaurantDTO> getAll(){
        List<Restaurant> restaurants = (List<Restaurant>) restaurantRepo.findAll();
        return mapper.toRestaurants(restaurants);
    }
   @Override
    public Optional<Restaurant> getById(long idRestaurant){
        Optional<Restaurant> restaurant = restaurantRepo.findById(idRestaurant);
        return mapper.toRestaurantsOptional(restaurant);
    }

    @Override
    public RestaurantDTO save(RestaurantDTO restaurantDTO){
        Restaurant restaurant = mapper.toRestaurant(restaurantDTO);
        return mapper.toRestaurantDTO(restaurantRepo.save(restaurant));
    }
    @Override
    public void deleteByID(long idRestaurant){
        restaurantRepo.deleteById(idRestaurant);
    }
}

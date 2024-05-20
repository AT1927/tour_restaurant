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
public class RestaurantRepository implements RestaurantRepositoryDomain {
    @Autowired
    public RestaurantCrudRepository restaurantRepo;
    @Autowired
    public RestaurantMapper mapper;

    @Override
    public List<RestaurantDTO> getAll(){
        List<Restaurant> restaurants = (List<Restaurant>) restaurantRepo.findAll();
        return mapper.toRestaurantsDTO(restaurants);
    }
   @Override
    public Optional<RestaurantDTO> getById(long idRestaurant){
        Optional<Restaurant> restaurant = restaurantRepo.findById(idRestaurant);
        return mapper.toRestaurantsOptional(restaurant);
    }

    @Override
    public RestaurantDTO save(RestaurantDTO restaurantDTO){
        Restaurant restaurant = mapper.toRestaurant(restaurantDTO);
        if (restaurant.getCreatedAt() == null){
            restaurant.setCreatedAt(java.time.LocalDateTime.now());
        }
        return mapper.toRestaurantDTO(restaurantRepo.save(restaurant));
    }
    @Override
    public void deleteByID(long idRestaurant){
        restaurantRepo.deleteById(idRestaurant);
    }
}

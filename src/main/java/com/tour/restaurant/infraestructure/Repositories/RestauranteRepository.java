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
public abstract class RestauranteRepository implements RestaurantRepositoryDomain {
    @Autowired
    public RestaurantCrudRepository restauranteRepo;
    @Autowired
    public RestaurantMapper mapper;

    @Override
    public List<RestaurantDTO> getAll(){
        List<Restaurant> restaurantes = (List<Restaurant>) restauranteRepo.findAll();
        return mapper.toRestaurants(restaurantes);
    }
   @Override
    public Optional<Restaurant> getById(long idRestaurant){
        Optional<Restaurant> restaurant = restauranteRepo.findById(idRestaurant);
        return mapper.toRestaurantsOptional(restaurant);
    }
    @Override
    public RestaurantDTO save(RestaurantDTO restaurantDTO){
        Restaurant restaurante = mapper.toRestaurant(restaurantDTO);
        return mapper.toRestaurantDTO(restauranteRepo.save(restaurante));
    }
    @Override
    public void deleteByID(long idRestaurant){
        restauranteRepo.deleteById(idRestaurant);
    }
}

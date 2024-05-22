package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.Domain.Repository.RestaurantRepositoryDomain;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepositoryDomain restaurantRepository;


    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantRepository.getAll();
        return new ArrayList<>(restaurants);
    }


    public Optional<RestaurantDTO> getRestaurantById(Long id) {
        return restaurantRepository.getById(id);
    }



    public RestaurantDTO save (RestaurantDTO restaurantDTO){
        return restaurantRepository.save(restaurantDTO);
    }

    public boolean delete(long id){
        if (getRestaurantById(id).isPresent()){
            restaurantRepository.deleteByID(id);
            return true;
        }
        return false;
    }

    public List<RestaurantDTO> getRestaurantsByname(String name){
        List<RestaurantDTO> restaurants = restaurantRepository.getAll();
        return restaurants.stream().filter(restaurantDTO -> restaurantDTO.getName().equals(name)).collect(Collectors.toList());
      }


    public List<RestaurantDTO> getRestaurantsByAddress(String address){
        List<RestaurantDTO> restaurants = restaurantRepository.getAll();
        return restaurants.stream().filter(restaurantDTO -> restaurantDTO.getAddress().equals(address)).collect(Collectors.toList());
     }

    public List<RestaurantDTO> getRestaurantsByType(String type){
       List<RestaurantDTO> restaurants = restaurantRepository.getAll();
         return restaurants.stream().filter(restaurantDTO -> restaurantDTO.getType().equals(type)).collect(Collectors.toList());
        }



}

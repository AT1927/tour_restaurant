package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.RestaurantDTO;
import com.tour.restaurant.infraestructure.Entities.Restaurant;
import com.tour.restaurant.Domain.Repository.RestaurantRepositoryDomain;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepositoryDomain restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepositoryDomain restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantDTO> getAll(){
        return restaurantRepository.getAll();
    }
    /*
    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantRepository.getAll();
        return new ArrayList<>(restaurants);
    }
    */
    public Optional<Restaurant> getById(long restaurantID){
        return restaurantRepository.getById(restaurantID);
    }

    public Optional<RestaurantDTO> getRestaurantById(Long id) {
        return restaurantRepository.getById(id);
    }

    public List<Restaurant> getByRestaurant(Restaurant restaurant){
        return restaurantRepository.getByRestaurant(restaurant);
    }

    public Restaurant save(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public RestaurantDTO save (RestaurantDTO restaurantDTO){
        return restaurantRepository.save(restaurantDTO);
    }

    public boolean delete(long id){
        if (getRestaurantById(id).isPresent()){
            restaurantRepository.delete(id);
            return true;
        }
        return false;
    }
    //-----------------------------------------------------------
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDto) {

        Restaurant restaurantEntity = convertToEntity(restaurantDto);


        Restaurant savedRestaurant = restaurantRepositoryDomain.save(restaurantEntity);


        return convertToDto(savedRestaurant);
    }


    private Restaurant convertToEntity(RestaurantDTO restaurantDto) {
        Restaurant restaurantEntity = new Restaurant();

        restaurantEntity.setName(restaurantDto.getName());
        restaurantEntity.setDescription(restaurantDto.getDescription());
        restaurantEntity.setAddress(restaurantDto.getAddress());
        return restaurantEntity;
    }


    private RestaurantDTO convertToDto(Restaurant restaurantEntity) {
        RestaurantDTO restaurantDto = new RestaurantDTO();
        restaurantDto.setName(restaurantEntity.getName());
        restaurantDto.setDescription(restaurantEntity.getDescription());
        restaurantDto.setAddress(restaurantEntity.getAddress());
        return restaurantDto;
    }
}

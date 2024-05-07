package com.tour.restaurant.application.controller;
import com.tour.restaurant.Domain.DTO.*;
import com.tour.restaurant.Domain.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAll(){
        return new ResponseEntity<>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<RestaurantDTO> getByID(@PathVariable("id") long restaurantID){
        return restaurantService.getRestaurantById(restaurantID).map(restaurantDTO -> new ResponseEntity<>(restaurantDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<RestaurantDTO> save (@RequestBody RestaurantDTO restaurant){
        return new ResponseEntity<>(restaurantService.save(restaurant),  HttpStatus.CREATED) ;
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete (@PathVariable("id") Long restaurantID){
        if (restaurantService.delete(restaurantID)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
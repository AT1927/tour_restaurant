package com.tour.restaurant.Domain.Repository;

import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TableFoodRepositoryDomain  {



    Optional<TableFood> findByNumberTable(int number);


    List<TableFood> findByIsAvailableTrue(Long idRestaurant);


    List<TableFood> findByIsAvailableFalse(Long idRestaurant);

    List<TableFoodDTO> findAll();

    Optional<TableFoodDTO> findById(Long id);

    TableFoodDTO save(TableFoodDTO table);

    void deleteById(Long id);
}


package com.tour.restaurant.Domain.Repository;

import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TableFoodRepositoryDomain  {

    Optional<TableFoodDTO> findByNumberTable(Integer numberTable);
    List<TableFoodDTO> findByIsAvailableTrue();
    List<TableFoodDTO> findByIsAvailableFalse();
    List<TableFoodDTO> findAll();
    Optional<TableFoodDTO> findById(Long id);
    TableFoodDTO save(TableFoodDTO table);
    void deleteById(Long id);
}


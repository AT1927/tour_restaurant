package com.tour.restaurant.infraestructure.Repositories.Crud;

import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TableFoodCrudRepository extends CrudRepository<TableFood, Long> {


    Optional<TableFoodDTO> findByNumberTable(Long numberTable);
    List<TableFood> findByIsAvailableTrue();
    public List<TableFoodDTO> findByIsAvailableFalse();



}
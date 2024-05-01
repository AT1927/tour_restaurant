package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.Repository.TableFoodRepositoryDomain;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class TableFoodService {

    @Autowired
    private TableFoodRepositoryDomain tableFoodRepositoryDomain;






}

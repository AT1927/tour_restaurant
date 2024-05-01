package com.tour.restaurant.infraestructure.Repositories;


import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.Domain.Repository.TableFoodRepositoryDomain;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.infraestructure.Mapper.TableFoodMapper;
import com.tour.restaurant.infraestructure.Repositories.Crud.TableFoodCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TableFoodRepository implements TableFoodRepositoryDomain{


    public TableFoodCrudRepository tableRepo ;

    public TableFoodMapper tableMapper ;


    @Override
    public Optional<TableFood> findByNumberTable(int number) {
        return Optional.empty();
    }

    @Override
    public List<TableFood> findByIsAvailableTrue(Long idRestaurant) {
        return null;
    }

    @Override
    public List<TableFood> findByIsAvailableFalse(Long idRestaurant) {

        return null;
    }

    @Override
    public List<TableFoodDTO> findAll() {
        List<TableFood> tables = (List<TableFood>) tableRepo.findAll();
        return tableMapper.toTablesFood(tables);
    }

    @Override
    public Optional<TableFoodDTO> findById(Long id) {
        Optional<TableFood> table = tableRepo.findById(id);
        return tableMapper.toTablesFoodOptional(table);
    }

    @Override
    public TableFoodDTO save(TableFoodDTO table) {
        TableFood tableFood = tableMapper.toTableFood(table);
        return tableMapper.toTableFoodDTO(tableRepo.save(tableFood));

    }

    @Override
    public void deleteById(Long id) {
        tableRepo.deleteById(id);
    }
}

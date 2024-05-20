package com.tour.restaurant.infraestructure.Repositories;


import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.Domain.Repository.TableFoodRepositoryDomain;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.infraestructure.Mapper.TableFoodMapper;
import com.tour.restaurant.infraestructure.Repositories.Crud.TableFoodCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class TableFoodRepository implements TableFoodRepositoryDomain{

    @Autowired
    public TableFoodCrudRepository tableRepo ;

    @Autowired
    public TableFoodMapper tableMapper ;


    @Override
    public Optional<TableFoodDTO> findByNumberTable(Integer numberTable) {
        Optional<TableFood> table = tableRepo.findByNumber(numberTable);
        if (table.isPresent()){
            return tableMapper.toTablesFoodOptional(table);
        }
        return Optional.empty();
    }
    @Override
    public List<TableFoodDTO> findByIsAvailableTrue() {
        List<TableFoodDTO> tablesAvailable;
        tablesAvailable = tableMapper.toTablesFoodDTO(tableRepo.findByAvailableTrue());
        return tablesAvailable;
    }

    @Override
    public List<TableFoodDTO> findByIsAvailableFalse() {
        List<TableFoodDTO> tablesUnAvailable;
        tablesUnAvailable = tableMapper.toTablesFoodDTO(tableRepo.findByAvailableFalse());
        return tablesUnAvailable;
    }
    @Override
    public TableFoodDTO save(TableFoodDTO table) {
        TableFood tableFood = tableMapper.toTableFood(table);

        if (tableFood.getCreatedAt() == null) {
            tableFood.setCreatedAt(LocalDateTime.now());
        }
        return tableMapper.toTableFoodDTO(tableRepo.save(tableFood));
    }


    @Override
    public List<TableFoodDTO> findAll() {
        List<TableFood> tables = (List<TableFood>) tableRepo.findAll();
        return tableMapper.toTablesFoodDTO(tables);
    }

    @Override
    public Optional<TableFoodDTO> findById(Long id) {
        Optional<TableFood> table = tableRepo.findById(id);
        return tableMapper.toTablesFoodOptional(table);
    }


    @Override
    public void deleteById(Long id) {
        tableRepo.deleteById(id);
    }
}

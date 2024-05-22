package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.Domain.Repository.TableFoodRepositoryDomain;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableFoodService {

    @Autowired
    private TableFoodRepositoryDomain repoTable;

    public Optional<TableFoodDTO> findByNumberTable(Integer numberTable){
        return repoTable.findByNumberTable(numberTable);
    }

    public List<TableFoodDTO> findByIsAvailableTrue(){
        return repoTable.findByIsAvailableTrue();
    }

    public List<TableFoodDTO> findByIsAvailableFalse(){
        return repoTable.findByIsAvailableFalse();
    }

    public List<TableFoodDTO> getAllTables(){
        List<TableFoodDTO> tables = repoTable.findAll();
        return new ArrayList<>(tables);
    }

    public Optional<TableFoodDTO> getTablebyId(Long id){
        return repoTable.findById(id);
    }

    public TableFoodDTO save(TableFoodDTO table){
        return repoTable.save(table);
    }

    public boolean deleteById(Long id){
        if (getTablebyId(id).isPresent()) {
            repoTable.deleteById(id);
            return true;
        }
        return false;
    }


    public List<TableFoodDTO> getAvailableTables() {
        return repoTable.findByIsAvailableTrue();
    }
}

package com.tour.restaurant.Domain.Service;

import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.Repository.TableFoodRepositoryDomain;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableFoodService {

    @Autowired
    private TableFoodRepositoryDomain repo ;

    @Autowired
    public TableFoodService(TableFoodRepositoryDomain repo) {
        this.repo = repo;
    }

    public Optional<TableFoodDTO> findByNumberTable(Integer numberTable){
        return repo.findByNumberTable(numberTable);
    }

    public List<TableFoodDTO> findByIsAvailableTrue(){
        return repo.findByIsAvailableTrue();
    }

    public List<TableFoodDTO> findByIsAvailableFalse(){
        return repo.findByIsAvailableFalse();
    }

    public List<TableFoodDTO> getAllTables(){
        List<TableFoodDTO> tables = repo.findAll();
        return new ArrayList<>(tables);
    }

    public Optional<TableFoodDTO> getTablebyId(Long id){
        return repo.findById(id);
    }

    public TableFoodDTO save(TableFoodDTO table){
        return repo.save(table);
    }

    public boolean deleteById(Long id){
        if (getTablebyId(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }








}

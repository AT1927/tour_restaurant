package com.tour.restaurant.application.controller;
import com.tour.restaurant.Domain.DTO.*;
import com.tour.restaurant.Domain.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/tableS")
public class TableFoodController {

    @Autowired
    private TableFoodService tableFoodService;

    @GetMapping
    public ResponseEntity<List<TableFoodDTO>> getAll(){
        return new ResponseEntity<>(tableFoodService.getAllTables(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<TableFoodDTO> getByID(@PathVariable("id") long tableID){
        return tableFoodService.getTablebyId(tableID).map(tableFoodDTO -> new ResponseEntity<>(tableFoodDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<TableFoodDTO> save (@RequestBody TableFoodDTO table){
        return new ResponseEntity<>(tableFoodService.save(table),  HttpStatus.CREATED) ;
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete (@PathVariable("id") Long tableID){
        if (tableFoodService.deleteById(tableID)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}

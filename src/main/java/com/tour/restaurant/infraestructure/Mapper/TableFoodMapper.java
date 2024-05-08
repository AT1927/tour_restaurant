package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TableFoodMapper {


    @Mappings({
            @Mapping(source = "id", target ="id"),
            @Mapping(source = "capacity", target ="capacity"),
            @Mapping(source = "number", target ="number"),
            @Mapping(source = "isAvailable", target ="isAvailable"),
            @Mapping( target ="created_at", ignore = true),
            @Mapping( target ="updated_at", ignore = true),
    })


    TableFoodDTO toTableFoodDTO(TableFood tableFood);
    List<TableFoodDTO> toTablesFoodDTO(List<TableFood> tablesFood);
    default Optional<TableFoodDTO> toTablesFoodOptional(Optional<TableFood> tableFood ){
        return  tableFood.map(this::toTableFoodDTO);
    }
    @InheritInverseConfiguration
    TableFood toTableFood(TableFoodDTO tableFoodDTO);
    List<TableFood> toTablesFood(List<TableFoodDTO> tablesDTO);


}


package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@Mapper(componentModel = "spring", uses = {RestaurantMapper.class, BookingMapper.class})
public interface TableFoodMapper {

    TableFoodMapper INSTANCE = Mappers.getMapper(TableFoodMapper.class);

    @Mappings({
            @Mapping(target = "isAvailable", source = "available"),
            @Mapping(target = "available", source = "isAvailable"),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })


    TableFoodDTO toTableFoodDTO(TableFood tableFood);
    List<TableFoodDTO> toTablesFoodDTO( List<TableFood> tablesFood);
    TableFood toTableFood(TableFoodDTO tableFoodDTO);
    List<TableFoodDTO> toTablesFood(List<TableFood> tables);

    default Optional<TableFoodDTO> toTablesFoodOptional(Optional<TableFood> tableFood ){
        return  tableFood.map(this::toTableFoodDTO);
    }
}


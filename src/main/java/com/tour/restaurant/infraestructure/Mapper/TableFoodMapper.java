package com.tour.restaurant.infraestructure.Mapper;

import com.tour.restaurant.Domain.DTO.BookingDTO;
import com.tour.restaurant.infraestructure.Entities.Booking;
import com.tour.restaurant.infraestructure.Entities.TableFood;
import com.tour.restaurant.Domain.DTO.TableFoodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {TableFoodMapper.class})

public interface TableFoodMapper {

    TableFoodMapper INSTANCE = Mappers.getMapper(TableFoodMapper.class);

    @Mapping(target = "isAvailable", source = "available")
    TableFoodDTO toTableFoodDTO(TableFood tableFood);

    @Mapping(target = "available", source = "isAvailable")
    TableFood toTableFood(TableFoodDTO tableFoodDTO);

    List<TableFoodDTO> toTablesFood(List<TableFood> bookings);

    default Optional<TableFoodDTO> toTablesFoodOptional(Optional<TableFood> tableFood ){
        return  tableFood.map(this::toTableFoodDTO);
    }
}


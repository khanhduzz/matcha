package com.fjb.inventory.mapper;

import com.fjb.inventory.dto.request.WarehouseRequestDto;
import com.fjb.inventory.dto.response.WarehouseResponseDto;
import com.fjb.inventory.entity.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {
    Warehouse toWarehouse(WarehouseRequestDto warehouseRequestDto);

    WarehouseResponseDto toWarehouseResponse(Warehouse warehouse);

    Warehouse updateWarehouse(@MappingTarget Warehouse warehouse, WarehouseRequestDto warehouseRequestDto);
}

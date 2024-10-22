package com.fjb.inventory.service;

import com.fjb.inventory.dto.request.WarehouseRequestDto;
import com.fjb.inventory.dto.response.WarehouseResponseDto;
import java.util.List;

public interface WarehouseService {
    WarehouseResponseDto createWarehouse(WarehouseRequestDto warehouseRequestDto);

    WarehouseResponseDto getWarehouseById(Long id);

    WarehouseResponseDto updateWarehouse(Long id, WarehouseRequestDto warehouseRequestDto);

    void deleteWarehouse(Long id);

    List<WarehouseResponseDto> getAllWarehouses();
}

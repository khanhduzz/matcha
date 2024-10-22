package com.fjb.inventory.service.impl;

import com.fjb.inventory.dto.request.WarehouseRequestDto;
import com.fjb.inventory.dto.response.WarehouseResponseDto;
import com.fjb.inventory.entity.Warehouse;
import com.fjb.inventory.exception.NotFoundException;
import com.fjb.inventory.mapper.WarehouseMapper;
import com.fjb.inventory.repository.WarehouseRepository;
import com.fjb.inventory.service.WarehouseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Override
    @Transactional
    public WarehouseResponseDto createWarehouse(WarehouseRequestDto warehouseRequestDto) {
        Warehouse warehouse = warehouseMapper.toWarehouse(warehouseRequestDto);
        return warehouseMapper.toWarehouseResponse(warehouseRepository.save(warehouse));
    }

    @Override
    public WarehouseResponseDto getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Warehouse not found"));
        return warehouseMapper.toWarehouseResponse(warehouse);
    }

    @Override
    @Transactional
    public WarehouseResponseDto updateWarehouse(Long id, WarehouseRequestDto warehouseRequestDto) {
        Warehouse warehouse = warehouseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Warehouse not found"));
        warehouse = warehouseMapper.updateWarehouse(warehouse, warehouseRequestDto);
        return warehouseMapper.toWarehouseResponse(warehouseRepository.save(warehouse));
    }

    @Override
    @Transactional
    public void deleteWarehouse(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Warehouse not found"));
        warehouseRepository.delete(warehouse);
    }

    @Override
    public List<WarehouseResponseDto> getAllWarehouses() {
        return warehouseRepository.findAll()
            .stream().map(warehouseMapper::toWarehouseResponse)
            .toList();
    }
}

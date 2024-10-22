package com.fjb.inventory.controller;

import com.fjb.inventory.dto.request.WarehouseRequestDto;
import com.fjb.inventory.dto.response.WarehouseResponseDto;
import com.fjb.inventory.service.WarehouseService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseResponseDto> getWarehouse(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(warehouseService.getWarehouseById(id));
    }

    @PostMapping
    public ResponseEntity<WarehouseResponseDto> createWarehouse(@RequestBody @Valid
                                                                WarehouseRequestDto warehouseRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseService.createWarehouse(warehouseRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseResponseDto> updateWarehouse(@PathVariable("id") Long id,
                                                                @RequestBody @Valid
                                                                WarehouseRequestDto warehouseRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(warehouseService.updateWarehouse(id, warehouseRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<WarehouseResponseDto>> getAllWarehouses() {
        return ResponseEntity.status(HttpStatus.OK).body(warehouseService.getAllWarehouses());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteWarehouse(@PathVariable("id") Long id) {
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

package com.fjb.product.dto.response.warehouse;

import com.fjb.product.config.InventoryApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WarehouseApiService {

    private final InventoryApiClient inventoryApiClient;

    public WarehouseResponseDto getWareHouseById(Long id) {
        return inventoryApiClient.getWarehouse(String.valueOf(id));
    }
}

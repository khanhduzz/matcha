package com.fjb.product.config;

import com.fjb.product.dto.response.warehouse.WarehouseResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "Inventory-Service", url = "${http.feignUrl.inventory}")
public interface InventoryApiClient {
    @GetMapping("api/warehouses/{id}")
    WarehouseResponseDto getWarehouse(@PathVariable("id") String Id);
}

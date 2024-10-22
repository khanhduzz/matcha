package com.fjb.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseRequestDto {

    @NotBlank(message = "Warehouse name not blank")
    private String name;

    @NotBlank(message = "Warehouse location not blank")
    private String location;

    private String description;
}

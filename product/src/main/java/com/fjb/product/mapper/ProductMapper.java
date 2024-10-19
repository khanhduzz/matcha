package com.fjb.product.mapper;

import com.fjb.product.dto.request.ProductCreateDto;
import com.fjb.product.dto.response.ProductResponseDto;
import com.fjb.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreateDto productCreateDto);

    ProductResponseDto toProductResponseDto(Product product);

    Product updateProduct(@MappingTarget Product product, ProductCreateDto productCreateDto);
}

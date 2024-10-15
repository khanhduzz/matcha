package com.fjb.product.service;

import com.fjb.product.dto.request.ProductCreateDto;
import com.fjb.product.dto.response.ProductResponseDto;
import com.fjb.product.entity.Product;
import com.fjb.product.mapper.ProductMapper;
import com.fjb.product.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto createProduct(ProductCreateDto productCreateDto) {
        Product product = productMapper.toProduct(productCreateDto);
        product = productRepository.save(product);
        return productMapper.toProductResponseDto(product);
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> list = productRepository.findAllByOrderByIdAsc();
        List<ProductResponseDto> reqList = new ArrayList<>();
        for (Product product : list) {
            reqList.add(productMapper.toProductResponseDto(product));
        }
        return reqList;
    }

    public ProductResponseDto getProduct(Long id) {
        Product product =  productRepository.findById(id);
        return productMapper.toProductResponseDto(product);
    }

    public ProductResponseDto saveExistingProduct(ProductResponseDto productResponseDto) {
        Product existingProduct = productRepository.findById(productResponseDto.getId());
        if (existingProduct == null) {
            throw new IllegalArgumentException("Product not found");
        } else {
            existingProduct.setName(productResponseDto.getName());
            existingProduct.setDescription(productResponseDto.getDescription());
            existingProduct.setPrice(productResponseDto.getPrice());
            Product product = productRepository.save(existingProduct);
            return productMapper.toProductResponseDto(product);
        }
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(String.valueOf(id));
    }
}

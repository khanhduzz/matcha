package com.fjb.product.service;

import com.fjb.product.dto.request.ProductCreateDto;
import com.fjb.product.dto.response.ProductResponseDto;
import com.fjb.product.entity.Product;
import com.fjb.product.exception.ErrorCreatingEntry;
import com.fjb.product.exception.NotFoundException;
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
        if (product == null) {
            throw new ErrorCreatingEntry("Could not create product");
        }
        return productMapper.toProductResponseDto(product);
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> list = productRepository.findAllByOrderByIdAsc();
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        List<ProductResponseDto> responseList = new ArrayList<>();
        list.forEach(product -> responseList.add(productMapper.toProductResponseDto(product)));
        return responseList;
    }

    public ProductResponseDto getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        return productMapper.toProductResponseDto(product);
    }

    public ProductResponseDto updateProduct(Long id, ProductCreateDto productCreateDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        product = productMapper.updateProduct(product, productCreateDto);
        return productMapper.toProductResponseDto(product);
    }

    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}

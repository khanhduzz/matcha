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
            throw new NotFoundException("No products found");
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

    public ProductResponseDto updateProduct(Long id, ProductCreateDto newProductCreateDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

        existingProduct.setName(
                newProductCreateDto.getName() != null
                        ? newProductCreateDto.getName() : existingProduct.getName()
        );
        existingProduct.setDescription(
                newProductCreateDto.getDescription() != null
                        ? newProductCreateDto.getDescription() : existingProduct.getDescription()
        );
        existingProduct.setPrice(
                newProductCreateDto.getPrice() != null
                        ? newProductCreateDto.getPrice() : existingProduct.getPrice()
        );

        return productMapper.toProductResponseDto(productRepository.save(existingProduct));
    }

    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}

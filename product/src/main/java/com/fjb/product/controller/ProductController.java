package com.fjb.product.controller;

import com.fjb.product.dto.request.ProductCreateDto;
import com.fjb.product.dto.response.ProductResponseDto;
import com.fjb.product.exception.ErrorCreatingEntry;
import com.fjb.product.exception.ProductNotFoundException;
import com.fjb.product.service.ProductService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8090")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductCreateDto productCreateDto) {
        try {
            ProductResponseDto productResponseDto = productService.createProduct(productCreateDto);
            if (productResponseDto == null) {
                throw new ErrorCreatingEntry("Could not create entry");
            } else {
                return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        try {
            List<ProductResponseDto> list = productService.getAllProducts();
            if (list.isEmpty()) {
                throw new ProductNotFoundException("No Entries found!");
            } else {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        try {
            ProductResponseDto productResponseDto = productService.getProduct(id);
            if (productResponseDto == null) {
                throw new ProductNotFoundException("No Entry found");
            }
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable Long id, @Valid @RequestBody ProductCreateDto newProductCreateDto
    ) {
        try {
            ProductResponseDto existingProduct = productService.getProduct(id);
            if (existingProduct != null) {
                String newName = newProductCreateDto.getName();
                String newDescription = newProductCreateDto.getDescription();
                BigDecimal newPrice = newProductCreateDto.getPrice();

                existingProduct.setName(
                        newName != null && !newName.isEmpty()
                                ? newName : existingProduct.getName()
                );
                existingProduct.setDescription(
                        newDescription != null && !newDescription.isEmpty()
                                ? newDescription : existingProduct.getDescription()
                );
                existingProduct.setPrice(
                        newPrice != null
                                ? newPrice : existingProduct.getPrice()
                );
                ProductResponseDto updated = productService.saveExistingProduct(existingProduct);
                return new ResponseEntity<>(updated, HttpStatus.CREATED);
            } else {
                throw new ProductNotFoundException("Entry not found");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProductById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

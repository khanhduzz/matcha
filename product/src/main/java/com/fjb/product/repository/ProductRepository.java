package com.fjb.product.repository;

import com.fjb.product.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findById(Long id);

    List<Product> findAllByOrderByIdAsc();
}

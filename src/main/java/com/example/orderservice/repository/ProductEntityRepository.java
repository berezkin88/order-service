package com.example.orderservice.repository;

import com.example.orderservice.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
}

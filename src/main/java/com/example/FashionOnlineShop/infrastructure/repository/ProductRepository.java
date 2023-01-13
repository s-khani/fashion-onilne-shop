package com.example.FashionOnlineShop.infrastructure.repository;

import com.example.FashionOnlineShop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

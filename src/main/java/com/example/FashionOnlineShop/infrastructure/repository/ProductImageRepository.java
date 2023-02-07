package com.example.FashionOnlineShop.infrastructure.repository;

import com.example.FashionOnlineShop.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
}

package com.example.FashionOnlineShop.application;

import com.example.FashionOnlineShop.presentation.controller.model.ProductImageDto;

import java.util.List;

public interface ProductImageService {
    void addProductImage(ProductImageDto dto);

    List<ProductImageDto> findAllImages();
}

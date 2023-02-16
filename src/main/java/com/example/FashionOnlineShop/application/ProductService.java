package com.example.FashionOnlineShop.application;


import com.example.FashionOnlineShop.presentation.controller.model.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto addProduct(ProductDto dto);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    void deleteProductById(Long id);

    ProductDto updateProductById(Long id, ProductDto requestDto);
}

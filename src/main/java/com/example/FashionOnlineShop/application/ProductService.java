package com.example.FashionOnlineShop.application;


import com.example.FashionOnlineShop.presentation.controller.model.ProductDto;

import java.util.List;

public interface ProductService {

    void addProduct(ProductDto dto);

    List<ProductDto> getAllProducts();
}

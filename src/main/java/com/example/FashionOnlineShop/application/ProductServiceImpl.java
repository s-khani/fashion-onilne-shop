package com.example.FashionOnlineShop.application;

import com.example.FashionOnlineShop.infrastructure.repository.ProductRepository;
import com.example.FashionOnlineShop.presentation.controller.model.ProductsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsConverter productsConverter;
    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductsDto dto) {

        var entity = productsConverter.fromDtoToEntity(dto);
        productRepository.save(entity);
    }
}

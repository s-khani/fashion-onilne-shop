package com.example.FashionOnlineShop.application;


import com.example.FashionOnlineShop.infrastructure.repository.ProductRepository;
import com.example.FashionOnlineShop.presentation.controller.model.ProductDto;
import com.example.FashionOnlineShop.presentation.controller.model.ProductImageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductDto dto) {

        var entity = productConverter.fromDtoToEntity(dto);
        productRepository.save(entity);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        var entities = productRepository.findAll();
        return entities.stream()
                .map(product -> productConverter.fromEntityToDto(product))
                .toList();

    }

    @Override
    public ProductImageDto getProductById(Long id) {

        return null;



    }
}

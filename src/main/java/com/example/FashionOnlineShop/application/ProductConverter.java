package com.example.FashionOnlineShop.application;

import com.example.FashionOnlineShop.domain.Product;
import com.example.FashionOnlineShop.presentation.controller.model.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ProductConverter implements Converter<Product, ProductDto> {

    @Override
    public ProductDto fromEntityToDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .subtitle(product.getSubtitle())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .unitPrice(product.getUnitPrice().toString())
                .productSize(product.getProductSize().toString())
                .isAvailability(product.getIsAvailability())
                .images(product.getImages())
                .build();
    }

    @Override
    public Product fromDtoToEntity(ProductDto dto) {


        return Product.builder()
                .name(dto.name())
                .subtitle(dto.subtitle())
                .description(dto.description())
                .quantity(dto.quantity())
                .unitPrice(new BigDecimal(dto.unitPrice()))
                .productSize(Product.ProductSize.valueOf(dto.productSize()))
                .isAvailability(dto.isAvailability())
                .build();

    }
}

package com.example.FashionOnlineShop.application;

import com.example.FashionOnlineShop.presentation.controller.model.ProductsDto;
import com.example.FashionOnlineShop.domain.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductsConverter implements Converter<Product, ProductsDto> {

    @Override
    public ProductsDto fromEntityToDto(Product product) {
        return ProductsDto.builder()
                .name(product.getName())
                .subtitle(product.getSubtitle())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .unitPrice(product.getUnitPrice())
                .isAvailability(product.getIsAvailability())
                .build();
    }

    @Override
    public Product fromDtoToEntity(ProductsDto dto) {
        return Product.builder()
                .name(dto.name())
                .subtitle(dto.subtitle())
                .description(dto.description())
                .quantity(dto.quantity())
                //ToDo: add logic String to BigDecimal
                .unitPrice(dto.unitPrice())
                .productSize(Product.ProductSize.valueOf(dto.productSize()))
                .isAvailability(dto.isAvailability())
                .build();
    }
}

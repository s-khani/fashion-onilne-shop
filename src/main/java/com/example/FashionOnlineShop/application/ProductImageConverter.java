package com.example.FashionOnlineShop.application;

import com.example.FashionOnlineShop.domain.ProductImage;
import com.example.FashionOnlineShop.presentation.controller.model.ProductImageDto;
import org.springframework.stereotype.Component;

@Component
public class ProductImageConverter implements Converter<ProductImage, ProductImageDto>{

    @Override
    public ProductImageDto fromEntityToDto(ProductImage productImage) {
        return ProductImageDto.builder()
                .imageTitle(productImage.getImageTitle())
                .enabled(productImage.getEnabled())
                .imageUrl(productImage.getImageUrl())
                .build();
    }

    @Override
    public ProductImage fromDtoToEntity(ProductImageDto productImageDto) {
        return ProductImage.builder()
                .imageTitle(productImageDto.imageTitle())
                .enabled(productImageDto.enabled())
                .imageUrl(productImageDto.imageUrl())
                .id(productImageDto.productId())
                .build();
    }
}

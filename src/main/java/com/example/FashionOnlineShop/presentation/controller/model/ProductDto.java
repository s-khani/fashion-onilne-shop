package com.example.FashionOnlineShop.presentation.controller.model;

import com.example.FashionOnlineShop.domain.ProductImage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;


import java.util.Set;

@Builder
public record ProductDto(

        @NotNull
        @NotBlank
        @Length(max = 200)
        String name,

        @Length(max = 200)
        String subtitle,

        String description,

        Integer quantity,

        String unitPrice,


        String productSize,

        Boolean isAvailability,

        Set<ProductImage> images


) {
}

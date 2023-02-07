package com.example.FashionOnlineShop.presentation.controller.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record ProductImageDto(

        @NotNull
        @NotBlank
        @Length(max = 200)
        String imageTitle,

        Boolean enabled,

        @NotNull
        @NotBlank
        @Length(max = 250)
        String imageUrl,

        long productId

) {
}

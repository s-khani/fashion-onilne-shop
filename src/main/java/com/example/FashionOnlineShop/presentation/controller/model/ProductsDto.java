package com.example.FashionOnlineShop.presentation.controller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record ProductsDto(

        @NotNull
        @NotBlank
        @Length(max = 200)
        String name,

        @Length(max = 200)
        String subtitle,

        String description,

        Integer quantity,

        //ToDo: change Integer to String
        Integer unitPrice,


        String productSize,

        Boolean isAvailability


) {
}

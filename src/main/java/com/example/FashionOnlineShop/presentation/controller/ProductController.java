package com.example.FashionOnlineShop.presentation.controller;

import com.example.FashionOnlineShop.application.ProductService;
import com.example.FashionOnlineShop.presentation.controller.model.ProductsDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping()
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductsDto request) {
        productService.addProduct(request);
        return ResponseEntity.ok("OK");
    }
}

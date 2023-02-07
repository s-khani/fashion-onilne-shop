package com.example.FashionOnlineShop.presentation.controller;

import com.example.FashionOnlineShop.application.ProductService;
import com.example.FashionOnlineShop.presentation.controller.model.ProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping()
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductDto request) {
        productService.addProduct(request);
        return ResponseEntity.ok("OK");

    }

    @GetMapping()
    public ResponseEntity<?> getAllProducts(){
      List<ProductDto> products =  productService.getAllProducts();
      return ResponseEntity.ok(products);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        var productImage = productService.getProductById(id);
        return ResponseEntity.ok(productImage);
    }

}

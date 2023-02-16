package com.example.FashionOnlineShop.presentation.controller.model;


import com.example.FashionOnlineShop.application.ProductImageService;
import com.example.FashionOnlineShop.domain.ProductImage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/productImages")
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductImageService productImageService;

    @PostMapping()
    public ResponseEntity<?> addProductImage(@RequestBody @Valid ProductImageDto request){
        productImageService.addProductImage(request);
        return ResponseEntity.ok("Image is added");
    }

    @GetMapping()
    public ResponseEntity<?> getAllImages(){

       List<ProductImageDto> productImages =  productImageService.findAllImages();
        return ResponseEntity.ok(productImages);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductImageById(@PathVariable Long id){
        var productImageDto = productImageService.getProductImageById(id);
       return  ResponseEntity.ok(productImageDto);
    }
}

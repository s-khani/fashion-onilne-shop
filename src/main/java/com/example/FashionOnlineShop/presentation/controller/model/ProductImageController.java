package com.example.FashionOnlineShop.presentation.controller.model;


import com.example.FashionOnlineShop.application.ProductImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        productImageService.findAllImages();
        return ResponseEntity.ok("Ok");

    }
}

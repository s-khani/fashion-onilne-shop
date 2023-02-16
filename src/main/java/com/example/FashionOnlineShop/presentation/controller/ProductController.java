package com.example.FashionOnlineShop.presentation.controller;

import com.example.FashionOnlineShop.application.ProductService;
import com.example.FashionOnlineShop.presentation.controller.model.ProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        var product = productService.addProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }

    @GetMapping()
    public ResponseEntity<?> getAllProducts(){
      List<ProductDto> products =  productService.getAllProducts();
      return ResponseEntity.ok(products);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        var product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Long id,ProductDto requestDto){
        var productDto = productService.updateProductById(id,requestDto);
        return ResponseEntity.ok(productDto);
    }

}

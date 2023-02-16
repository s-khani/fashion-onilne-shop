package com.example.FashionOnlineShop.application;


import com.example.FashionOnlineShop.exception.NotFoundException;
import com.example.FashionOnlineShop.exception.isAlreadyExistedException;
import com.example.FashionOnlineShop.infrastructure.repository.ProductImageRepository;
import com.example.FashionOnlineShop.presentation.controller.model.ProductImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImp implements ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductImageConverter productImageConverter;

    @Override
    public void addProductImage(ProductImageDto dto) {
        var productImage = productImageConverter.fromDtoToEntity(dto);
        if(productImageRepository.existsProductImageByImageUrl(productImage.getImageUrl())){
            throw new isAlreadyExistedException("This image is already existed");
        }
        else{
            productImageRepository.save(productImage);
        }

    }

    @Override
    public List<ProductImageDto> findAllImages() {
        var productImages = productImageRepository.findAll();
        return productImages.stream()
                .map(productImage -> productImageConverter.fromEntityToDto(productImage))
                .toList();
    }

    @Override
    public ProductImageDto getProductImageById(Long id) {
        var productImage = productImageRepository.findById(id);
        if(productImage.isPresent()){
            return productImageConverter.fromEntityToDto(productImage.get());
        }
        else {
            throw new NotFoundException("ProductImage by this id is does not exist");
        }

    }
}

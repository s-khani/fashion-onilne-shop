package com.example.FashionOnlineShop.application;



import com.example.FashionOnlineShop.domain.Product;
import com.example.FashionOnlineShop.exception.NotFoundException;
import com.example.FashionOnlineShop.exception.isAlreadyExistedException;
import com.example.FashionOnlineShop.infrastructure.repository.ProductRepository;
import com.example.FashionOnlineShop.presentation.controller.model.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    @Override
    public ProductDto addProduct(ProductDto dto) {

        var entity = productConverter.fromDtoToEntity(dto);
        if(productRepository.existsProductByName(entity.getName())){
            throw new isAlreadyExistedException("Product with this name is already existed.");
        }
        else{
            var product = productRepository.save(entity);
            return  productConverter.fromEntityToDto(product);

        }

    }

    @Override
    public List<ProductDto> getAllProducts() {
        var entities = productRepository.findAll();
        return entities.stream()
                .map(product -> productConverter.fromEntityToDto(product))
                .toList();

    }
    /*@Override
    public ResponseEntity<ProductDto> getProductById(Long id) {

        var product = productRepository.findById(id);
        if (product.isPresent()) {

            return ResponseEntity.ok(productConverter.fromEntityToDto(product.get()));
        }
        else{
           return ResponseEntity.notFound().build();
        }*/

    @Override
    public ProductDto getProductById(Long id) {

        var product = productRepository.findById(id);
        if (product.isPresent()) {

            return productConverter.fromEntityToDto(product.get());
        }
        else{
            throw new NotFoundException("User Not found by this id " + id);
        }

    }

    @Override
    public void deleteProductById(Long id) {

        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("Product with this id does not exist");
        }
    }

    @Override
    public ProductDto updateProductById(Long id, ProductDto requestDto) {
        Product request = productConverter.fromDtoToEntity(requestDto);
        var product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new NotFoundException("Product not found with this id" + id);
        }

        Product existingProduct = product.get();
        if(!(existingProduct.getName().equals(request.getName()))
                &&productRepository.existsProductByName(request.getName())){
            throw new isAlreadyExistedException("A product with name " + request.getName() + "already exist");
        }
        existingProduct.setName(request.getName());
        existingProduct.setSubtitle(request.getSubtitle());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setQuantity(request.getQuantity());
        existingProduct.setUnitPrice(request.getUnitPrice());
        existingProduct.setProductSize(request.getProductSize());
        existingProduct.setIsAvailability(request.getIsAvailability());
        productRepository.save(existingProduct);
        return productConverter.fromEntityToDto(existingProduct);


    }


}

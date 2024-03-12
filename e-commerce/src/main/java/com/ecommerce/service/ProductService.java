package com.ecommerce.service;

import com.ecommerce.dto.request.CreateProductDto;
import com.ecommerce.dto.request.UpdateProductDto;
import com.ecommerce.dto.response.ProductDto;

import java.util.List;

public interface ProductService {

    void createProduct(CreateProductDto createProductDto);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    void addProductToCard(Long productId, Long customerId);

    void removeProductFromCard(Long productId , Long cartId);

    void deleteProductById(Long productId);
    ProductDto updateProduct(UpdateProductDto updateProductDto );

}

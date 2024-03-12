package com.ecommerce.mapper.product;

import com.ecommerce.dto.request.UpdateProductDto;
import com.ecommerce.entity.Product;

import java.time.LocalDate;

public class MapWithObject {

   public static Product convertToEntity(UpdateProductDto updateProductDto, Product product){

       product.setModifiedDate(LocalDate.now());
       product.setStock(updateProductDto.getStock());
       product.setPrice(updateProductDto.getPrice());
       product.setDescription(updateProductDto.getDescription());
       product.setName(updateProductDto.getName());

       return product;
    }
}

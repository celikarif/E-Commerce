package com.ecommerce.dto.response;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private Double price;
    private String description;
    private Integer stock;
}

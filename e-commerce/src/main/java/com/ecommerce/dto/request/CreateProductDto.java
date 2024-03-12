package com.ecommerce.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateProductDto {
    private String name;
    private Double price;
    private String description;
    private Integer stock;
}

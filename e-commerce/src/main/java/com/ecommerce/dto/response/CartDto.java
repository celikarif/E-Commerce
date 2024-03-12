package com.ecommerce.dto.response;

import com.ecommerce.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CartDto {

    private Double totalAmount;
    private String customerName;
    private List<Product> products;

}

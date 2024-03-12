package com.ecommerce.dto.response;


import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String customerName;
    private String orderNo;
    private LocalDate orderDate;
    private String phoneNumber;
    private String address;
    private List<Product> products;
    private Double totalAmount;

}

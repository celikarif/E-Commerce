package com.ecommerce.dto.response;


import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private String phoneNumber;
    private String birthday;
    private String address;
    private String email;
}

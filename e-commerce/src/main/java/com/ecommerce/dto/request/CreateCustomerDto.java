package com.ecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerDto {
    private String name;
    private String phoneNumber;
    private LocalDate birthday;
    private String address;
    private String email;

}

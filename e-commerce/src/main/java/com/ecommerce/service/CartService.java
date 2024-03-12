package com.ecommerce.service;

import com.ecommerce.dto.response.CartDto;

public interface CartService {


    void emptyCartById(Long cartId);

    CartDto getCartById(Long cartId);
}

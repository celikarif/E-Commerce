package com.ecommerce.mapper.cart;

import com.ecommerce.dto.response.CartDto;
import com.ecommerce.dto.response.OrderDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Order;

public class MapWithObject {

   public static CartDto convertToDto(Cart cart){
       CartDto cartDto = new CartDto();
       cartDto.setTotalAmount(cart.getTotalAmount());
       cartDto.setProducts(cart.getProducts());
       cartDto.setCustomerName(cart.getCustomer().getName());

    return cartDto;
    }
}

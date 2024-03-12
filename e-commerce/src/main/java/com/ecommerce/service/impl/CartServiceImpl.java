package com.ecommerce.service.impl;

import com.ecommerce.dto.response.CartDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Product;
import com.ecommerce.mapper.MapperService;
import com.ecommerce.mapper.cart.MapWithObject;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    @Override
    public void emptyCartById(Long cartId) {
        Cart cart = this.cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException ("cart not found with id: " + cartId));
        cart.setProducts(new ArrayList<Product>());
        cart.setTotalAmount(0.0);

        this.cartRepository.save(cart);
    }

    @Override
    public CartDto getCartById(Long cartId) {
        Cart cart = this.cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException ("cart not found with id: " + cartId));
       return MapWithObject.convertToDto(cart);
    }
}

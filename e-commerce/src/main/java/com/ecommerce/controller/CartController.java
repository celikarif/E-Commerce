package com.ecommerce.controller;


import com.ecommerce.dto.response.CartDto;
import com.ecommerce.service.CartService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
@NoArgsConstructor
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping
    public CartDto getCartById(@RequestParam("cartId") Long cartId){
        return this.cartService.getCartById(cartId);
    }

    @PutMapping
    public void emptyCartById(@RequestParam("cartId") Long cartId){
        this.cartService.emptyCartById(cartId);
    }
}

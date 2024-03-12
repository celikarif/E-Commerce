package com.ecommerce.controller;


import com.ecommerce.dto.response.OrderDto;
import com.ecommerce.entity.Order;
import com.ecommerce.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
@NoArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderDto placeOrder(@RequestParam("customerId") Long customerId ){
        return this.orderService.placeOrder(customerId);
    }
    @GetMapping("/bycode")
    public  OrderDto getOrderForCode(@RequestParam("code") String code){
    return this.orderService.getOrderForCode(code);
    }

    @GetMapping("/byno")
    public  OrderDto getOrderForNo(@RequestParam("no") String no){
        return this.orderService.getOrderForOrderNo(no);
    }
    @GetMapping("/all")
    public List<OrderDto> getAllOrdersForCustomer(@RequestParam("customerId") Long customerId){
      return   this.orderService.getAllOrdersForCustomer(customerId);
    }

}

package com.service.order.controller;

import com.service.order.domain.Order;
import com.service.order.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping(path = "/insertOrder", consumes = "application/json")
    public void insertOrder(@RequestBody Order order){
        try {
            orderService.insertOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

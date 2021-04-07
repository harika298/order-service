package com.service.order.controller;

import com.service.order.domain.Order;
import com.service.order.serviceImpl.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    Service service;

    @PostMapping(path = "/insertOrder", consumes = "application/json", produces = "application/json")
    public void insertCustomer(@RequestBody Order order){
        service.insertOrder(order);
    }
}

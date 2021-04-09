package com.service.order.controller;

import com.service.order.domain.Order;
import com.service.order.domain.Product;
import com.service.order.domain.ProductType;
import com.service.order.repository.ProductServiceProxy;
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

    @Autowired
    ProductServiceProxy productServiceProxy;

    @PostMapping(path = "/insertOrder", consumes = "application/json", produces = "application/json")
    public void insertOrder(@RequestBody Order order){
        int prodId = 0;
        for (Product p: order.getOrderedProducts()) {
            prodId = p.getProductId();
        }
        ProductType productType = productServiceProxy.findProductById(prodId);
        if(productType!=null) {
            service.insertOrder(order);
        }else{
            try {
                throw new Exception("Product not there. please try again..");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.service.order.serviceImpl;

import com.service.order.domain.Order;
import com.service.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    OrderRepo repo;

    public void insertOrder(Order order){
        repo.save(order);
    }
}

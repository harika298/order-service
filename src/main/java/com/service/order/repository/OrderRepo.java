package com.service.order.repository;

import com.service.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(nativeQuery = true, value = "SELECT order_id From order_service.orders Order By order_id desc limit 1 offset 0")
    int findLatestOrderById();
}

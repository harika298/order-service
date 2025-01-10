package com.service.order.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "orders")
public class Order {

    @Id
    private int orderId;

    private Date dateOfOrder;
    private String description;
    private float actualPrice;
    private float discountPrice;
    private float totalOrderPrice;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonBackReference("orderedProducts")
    List<Product> orderedProducts;

    public Order() {
    }
}


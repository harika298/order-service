package com.service.order.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int orderId;
    private Date dateOfOrder;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> orderedProducts;

    public Order() {
    }

    public Order(int orderId, Date dateOfOrder, String description, Customer customer, Set<Product> orderedProducts) {
        this.orderId = orderId;
        this.dateOfOrder = dateOfOrder;
        this.description = description;
        this.customer = customer;
        this.orderedProducts = orderedProducts;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Set<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", dateOfOrder=" + dateOfOrder +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                ", orderedProducts=" + orderedProducts +
                '}';
    }
}


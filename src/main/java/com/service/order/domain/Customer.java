package com.service.order.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private int custId;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "add_id")
    private Address address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = {CascadeType.ALL},
            targetEntity = Order.class)
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(int custId, String name, Address address, List<Order> orderList) {
        this.custId = custId;
        this.name = name;
        this.address = address;
        this.orderList = orderList;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

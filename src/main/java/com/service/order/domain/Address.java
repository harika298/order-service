package com.service.order.domain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    private int addId;

    private String city;
    private String state;
    private String zip;
    private String contactNum;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Customer customer;

    public Address() {
    }

    public Address(int addId, String city, String state, String zip, String contactNum, Customer customer) {
        this.addId = addId;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.contactNum = contactNum;
        this.customer = customer;
    }

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addId=" + addId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", contactNum=" + contactNum +
                '}';
    }
}

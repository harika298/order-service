package com.service.order.dto;

public class CustomerDto {

    private int custId;
    private String name;

    AddressDto addressDto;

    public CustomerDto() {
    }

    public CustomerDto(int custId, String name, AddressDto addressDto) {
        this.custId = custId;
        this.name = name;
        this.addressDto = addressDto;
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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "custId=" + custId +
                ", name='" + name + '\'' +
                ", addressDto=" + addressDto +
                '}';
    }
}

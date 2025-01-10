package com.service.order.dto;

import lombok.Data;

@Data
public class AddressDto {

    private int addId;
    private String city;
    private String state;
    private String zip;
    private String contactNum;


}

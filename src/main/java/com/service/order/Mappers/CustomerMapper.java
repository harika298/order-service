package com.service.order.Mappers;

import com.service.order.domain.Address;
import com.service.order.domain.Customer;
import com.service.order.dto.AddressDto;
import com.service.order.dto.CustomerDto;

public class CustomerMapper {

    public static CustomerDto mapCustomerEntityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustId(customer.getCustId());
        customerDto.setName(customer.getName());


        AddressDto addressDto = new AddressDto();
        addressDto.setAddId(customer.getAddress().getAddId());
        addressDto.setCity(customer.getAddress().getCity());
        addressDto.setState(customer.getAddress().getState());
        addressDto.setZip(customer.getAddress().getZip());
        addressDto.setContactNum(customer.getAddress().getContactNum());

        customerDto.setAddressDto(addressDto);
        return customerDto;
    }
    public static Customer mapDtoToAddressEntitity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustId(customerDto.getCustId());
        customer.setName(customerDto.getName());

        Address address = new Address();
        address.setAddId(customerDto.getAddressDto().getAddId());
        address.setCity(customerDto.getAddressDto().getCity());
        address.setState(customerDto.getAddressDto().getState());
        address.setZip(customerDto.getAddressDto().getZip());
        address.setContactNum(customerDto.getAddressDto().getContactNum());

        customer.setAddress(address);
                return customer;

    }

}

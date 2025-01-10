package com.service.order.controller;

import com.service.order.domain.Customer;
import com.service.order.dto.CustomerDto;
import com.service.order.serviceImpl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer_service")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping(path = "/insertCustomer", consumes = "application/json")
    public void insertCustomer(@RequestBody CustomerDto customerDto) {
        customerService.insertCustomer(customerDto);
    }

    @GetMapping(path = "/getCustomer/{custId}", produces = "application/json")
    public CustomerDto getCustomerById(@PathVariable int custId) {
        return customerService.getCustomerById(custId);
    }

    @GetMapping(path = "/getAllCustomers", produces = "application/json")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/getCustomerMetaDataById/{custId}", produces = "application/json")
    public Customer getCustomerMetaDataById(@PathVariable int custId) {
        return customerService.getCustomerMetaDataById(custId);
    }

    @GetMapping(path = "/checkForDiscount/{custId}", produces = "application/json")
    public Boolean checkForDiscount(@PathVariable int custId) {
        return customerService.checkForDiscount(custId);
    }

    @DeleteMapping(path = "/deleteCustomer/{custId}")
    public HttpStatus deleteCustomerById(@PathVariable int custId) {
        customerService.deleteCustomerById(custId);
        return HttpStatus.OK;
    }

    @PutMapping(path = "/updateCustomer", consumes = "application/json")
    public void updateCustomer(@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);

    }

}

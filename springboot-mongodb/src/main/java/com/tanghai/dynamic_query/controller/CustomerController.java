package com.tanghai.dynamic_query.controller;

import com.tanghai.dynamic_query.model.Customer;
import com.tanghai.dynamic_query.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name) {
        log.info("Getting customer by name {} ", name);
        List customerList = customerService.getCustomerByName(name);
        log.info("Received {} customers by name {}", customerList.size(), name);
        return customerList;
    }




    @PostMapping("/customers/save")
    public Customer addCustomer(@RequestBody Customer customer) {
        log.info("Adding user {} to the Database", customer.getName());
        return customerService.addCustomer(customer);
    }
}
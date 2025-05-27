package com.tanghai.dynamic_query.controller;

import com.tanghai.dynamic_query.model.CustomerContactDetails;
import com.tanghai.dynamic_query.service.CustomerContactDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerContactDetailsController {

    @Autowired
    CustomerContactDetailsService customerContactDetailsService;

    @GetMapping("/contacts/{email}")
    public CustomerContactDetails getCustomerByEmail(@PathVariable String email) {
        log.info("Getting customer contact details by email {} ", email);
        CustomerContactDetails customerContactDetails = customerContactDetailsService.getCustomerContactDetailsByEmail(email);
        log.info("Received {} customer contact detail by email {}", customerContactDetails.getMobile(), email);
        return customerContactDetails;
    }

    @PostMapping("/contacts/save")
    public CustomerContactDetails addCustomerContactDetails(@RequestBody CustomerContactDetails customerContactDetails) {
        log.info("Adding contact details {} to the Database", customerContactDetails.getEmail());
        return customerContactDetailsService.addCustomerContactDetails(customerContactDetails);
    }
}
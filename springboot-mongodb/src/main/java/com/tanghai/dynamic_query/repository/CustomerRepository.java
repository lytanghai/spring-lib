package com.tanghai.dynamic_query.repository;

import com.tanghai.dynamic_query.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByName(String name);
    List<Customer> findByRole(String role);

}
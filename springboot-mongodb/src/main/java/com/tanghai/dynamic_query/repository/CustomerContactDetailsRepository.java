package com.tanghai.dynamic_query.repository;

import com.tanghai.dynamic_query.model.CustomerContactDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerContactDetailsRepository extends MongoRepository<CustomerContactDetails, String> {

    CustomerContactDetails findByEmail(String email);
    CustomerContactDetails findByMobile(String mobile);

}
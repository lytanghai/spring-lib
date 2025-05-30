package com.tanghai.dynamic_query.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Customer {

    @Id
    private String id;

    private String name;

    private String role;

    private int age;

    private String contactId;

}
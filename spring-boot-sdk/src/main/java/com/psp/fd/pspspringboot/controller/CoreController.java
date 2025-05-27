package com.psp.fd.pspspringboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("users")
public class CoreController {

    @PostMapping("/create")
    private void createUser() {

    }

}

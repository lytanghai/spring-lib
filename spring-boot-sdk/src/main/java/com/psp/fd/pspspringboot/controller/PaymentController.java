package com.psp.fd.pspspringboot.controller;

import com.psp.fd.pspspringboot.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("check/payment")
    private double checkPayment() throws Exception {
        return paymentService.checkPayment();
    }
}

package com.psp.fd.pspspringboot.interfaces;

public interface PaymentService {

    default Double checkPayment() throws Exception {
        throw new Exception("PaymentServiceI check old not yet implemented");
    }

    default Double confirmPayment() throws Exception {
        throw new Exception("PaymentServiceI confirm old not yet implemented");
    }
}

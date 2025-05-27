package com.psp.fd.pspspringboot.service.Payment;

import com.psp.fd.pspspringboot.service.AbstractPaymentService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends AbstractPaymentService {

    private static final JSONObject requestKeyForPayment = new JSONObject()
            .put("code", "string");

    @Override
    public Double checkPayment() throws Exception {
        return 50.20;
    }

    @Override
    public Double confirmPayment() throws Exception {
        return 50.20;
    }
}

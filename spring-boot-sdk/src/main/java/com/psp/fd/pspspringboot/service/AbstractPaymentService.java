package com.psp.fd.pspspringboot.service;

import com.psp.fd.pspspringboot.dto.ListDataDetail;
import com.psp.fd.pspspringboot.dto.ListUserRequest;
import com.psp.fd.pspspringboot.dto.ListUserResponse;
import com.psp.fd.pspspringboot.interfaces.PaymentService;

public abstract class AbstractPaymentService implements PaymentService {
    @Override
    public Double checkPayment() throws Exception {
        return PaymentService.super.checkPayment();
    }

    @Override
    public Double confirmPayment() throws Exception {
        return PaymentService.super.confirmPayment();
    }


    public <S extends ListUserRequest, T extends ListUserResponse>ListDataDetail listDataDetail(S request) {
        request.getAgentId();
        return new ListDataDetail();
    }
}

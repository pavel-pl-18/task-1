package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.payment.bank.BankReceiv;
import com.hexad.sales.round1.entities.rools.PaymentRool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentReceiveServiceImpl {

    public boolean determinePaymentPurpose(List<PaymentRool> roolsSet, BankReceiv bankReceiv) {
        return false;
    }
}

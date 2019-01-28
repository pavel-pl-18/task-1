package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.payment.bank.BankReceiv;
import com.hexad.sales.round1.entities.rools.PaymentRool;
import com.hexad.sales.round1.enums.PaymentPurposeType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentReceiveServiceImpl {

  public boolean determinePaymentPurpose(List<PaymentRool> roolsSet, BankReceiv bankReceiv) {
    roolsSet.forEach(paymentRool -> {
      PaymentPurposeType paymentPurposeType = paymentRool
          .determinePaymentPurpose(bankReceiv.getComment());
      if (paymentPurposeType != PaymentPurposeType.UNDEFINED) {
        bankReceiv.setPaymentPurposeType(paymentPurposeType);
        return;
      }
    });
    if (bankReceiv.getPaymentPurposeType() == null
        || bankReceiv.getPaymentPurposeType() == PaymentPurposeType.UNDEFINED) {
      return false;
    }
    return true;
  }
}

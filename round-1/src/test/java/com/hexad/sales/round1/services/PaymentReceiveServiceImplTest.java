package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.payment.bank.BankReceiv;
import com.hexad.sales.round1.entities.rools.PaymentRool;
import com.hexad.sales.round1.utils.DataStubs;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentReceiveServiceImplTest {

  PaymentReceiveServiceImpl paymentReceiveService = new PaymentReceiveServiceImpl();
  List<PaymentRool> roolsSet = null;

  {
    roolsSet = DataStubs.getPaymentRoolSet();
  }


  @Test
  void determine_payment_purpose_ok() {
    // given
    BankReceiv bankReceiv = DataStubs.getBankReceivValidComment();
    // when
    boolean actual = paymentReceiveService.determinePaymentPurpose(roolsSet, bankReceiv);
    // then
    assertTrue(actual);
  }

  @Test
  void determine_payment_purpose_not_ok() {
    // given
    BankReceiv bankReceiv = DataStubs.getBankReceivInValidComment();
    // when
    boolean actual = paymentReceiveService.determinePaymentPurpose(roolsSet, bankReceiv);
    // then
    assertFalse(actual);
  }




}
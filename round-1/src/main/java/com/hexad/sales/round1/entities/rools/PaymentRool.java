package com.hexad.sales.round1.entities.rools;

import com.hexad.sales.round1.enums.PaymentPurposeType;

import java.time.LocalDate;

/**
 * We consider rules, based on payment sum
 */
public interface PaymentRool {
  boolean isExpeired();

  LocalDate getExpirationDate();

  PaymentPurposeType determinePaymentPurpose(String paymentComment);

  PaymentPurposeType getPaymentPurposeType();
}

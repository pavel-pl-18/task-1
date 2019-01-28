package com.hexad.sales.round1.entities.payment.bank;

import com.hexad.sales.round1.enums.PaymentPurposeType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankReceiv {
  private Long id;
  private Long firmId;
  private BigDecimal sum;
  private String comment;
  private PaymentPurposeType paymentPurposeType;
}

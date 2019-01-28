package com.hexad.sales.round1.entities.rools;

import com.hexad.sales.round1.enums.PaymentPurposeType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class PaymentRoolImpl implements PaymentRool {

  private LocalDate expirationDate;
  private Pattern pattern;
  private PaymentPurposeType paymentPurposeType;

  public PaymentRoolImpl(String patternString, PaymentPurposeType paymentPurposeType) {
    this.pattern = Pattern.compile(patternString);
    this.paymentPurposeType = paymentPurposeType;
  }

  @Override
  public boolean isExpeired() {

    return false;
  }

  @Override
  public LocalDate getExpirationDate() {
    return null;
  }

  @Override
  public PaymentPurposeType determinePaymentPurpose(String paymentComment) {
    if (StringUtils.isEmpty(paymentComment)) {
      return PaymentPurposeType.UNDEFINED;
    }
    Matcher matcher = pattern.matcher(paymentComment);
    return matcher.find() ? this.paymentPurposeType : PaymentPurposeType.UNDEFINED;
  }
}

package com.hexad.sales.round1.utils;

import com.hexad.sales.round1.entities.payment.bank.BankReceiv;
import com.hexad.sales.round1.entities.rools.PaymentRool;
import com.hexad.sales.round1.entities.rools.PaymentRoolImpl;
import com.hexad.sales.round1.entities.rools.RoolsConstants;
import com.hexad.sales.round1.enums.PaymentPurposeType;

import java.util.ArrayList;
import java.util.List;

public class DataStubs {
  public static List<PaymentRool> getPaymentRoolSet() {
    List<PaymentRool> toReturn = new ArrayList<>();
    toReturn.add(new PaymentRoolImpl(RoolsConstants.PATTERN_FOR_PRODUCT, PaymentPurposeType.PRODUCTS));
/*
        for (String str : new String[]{RoolsConstants.PATTERN_FOR_PRODUCT,
                RoolsConstants.PATTERN_FOR_BOOK,
                RoolsConstants.PATTERN_FOR_MEMBERSHIP,
                RoolsConstants.PATTERN_FOR_UPGRATE_MEMEBERSHIP,
                RoolsConstants.PATTERN_FOR_VIDEO
        }) {
            toReturn.add()
        }
*/
    return toReturn;
  }

  public static BankReceiv getBankReceivValidComment() {
    BankReceiv toReturn = new BankReceiv();
    toReturn.setComment(RoolsConstants.PATTERN_FOR_PRODUCT);
    return toReturn;
  }

  public static BankReceiv getBankReceivInValidComment() {
    BankReceiv toReturn = new BankReceiv();
    return toReturn;
  }





}

package com.hexad.sales.round1.entities.rools;

import java.time.LocalDate;

/**
 * We consider rules, based on payment sum
 */
public interface PaymentRools {
    boolean isExpeired();
    LocalDate getExpirationDate();

}

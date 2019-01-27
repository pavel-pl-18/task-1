package com.hexad.sales.round1.entities.payment.bank;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankReceiv {
    private Long id;
    private BigDecimal sum;
    private String comment;
}

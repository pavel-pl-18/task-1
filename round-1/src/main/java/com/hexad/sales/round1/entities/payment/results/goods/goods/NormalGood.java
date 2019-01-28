package com.hexad.sales.round1.entities.payment.results.goods.goods;

import com.hexad.sales.round1.entities.payment.results.goods.AbstractGood;
import com.hexad.sales.round1.enums.GoodType;

/**
 * Just a sale without any complications
 */
public class NormalGood extends AbstractGood {
  public NormalGood(GoodType goodType, String name) {
    super(goodType, name);
  }

  @Override
  protected void construct() {

  }

  @Override
  protected void runServiceAfterShipping() {

  }
}

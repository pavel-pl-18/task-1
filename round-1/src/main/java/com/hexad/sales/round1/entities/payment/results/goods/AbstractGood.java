package com.hexad.sales.round1.entities.payment.results.goods;

import com.hexad.sales.round1.enums.GoodType;

public abstract class AbstractGood {
  private String name;
  private final GoodType goodType;


  public AbstractGood(GoodType goodType, String name) {
    this.goodType = goodType;
    this.name = name;
    construct();
  }


  protected abstract void construct();
  protected abstract void runServiceAfterShipping();


  public String getName() {
    return name;
  }

  public GoodType getGoodType() {
    return goodType;
  }
}

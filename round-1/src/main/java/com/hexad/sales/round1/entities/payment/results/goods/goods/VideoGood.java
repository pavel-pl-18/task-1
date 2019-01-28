package com.hexad.sales.round1.entities.payment.results.goods.goods;                                                           ;

import com.hexad.sales.round1.entities.payment.results.goods.AbstractGood;
import com.hexad.sales.round1.enums.GoodType;
import com.hexad.sales.round1.services.shipping.ShippingService;

public class VideoGood extends AbstractGood {

  private final ShippingService shippingService;


  public VideoGood(GoodType goodType, String name, ShippingService shippingService) {
    super(goodType, name);
    this.shippingService = shippingService;
  }

  @Override
  protected void construct() {

  }

  @Override
  protected void runServiceAfterShipping() {
    shippingService.generatePackingSlipForShipping(this);

  }
}

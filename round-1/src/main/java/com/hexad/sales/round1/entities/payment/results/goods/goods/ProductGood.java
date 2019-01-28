package com.hexad.sales.round1.entities.payment.results.goods.goods;

import com.hexad.sales.round1.entities.payment.results.goods.AbstractGood;
import com.hexad.sales.round1.enums.GoodType;
import com.hexad.sales.round1.services.shipping.CommisionPaymentService;
import com.hexad.sales.round1.services.shipping.ShippingService;

public class ProductGood extends AbstractGood {

  private final ShippingService shippingService;
  private final CommisionPaymentService commisionPaymentService;

  public ProductGood(GoodType goodType, String name, ShippingService shippingService,
                     CommisionPaymentService commisionPaymentService) {
    super(goodType, name);
    this.shippingService = shippingService;
    this.commisionPaymentService = commisionPaymentService;
  }

  @Override
  protected void construct() {

  }

  @Override
  protected void runServiceAfterShipping() {
    shippingService.generatePackingSlipForShipping();
    commisionPaymentService.generateCommisionPaymentForAgent();
  }


}

package com.hexad.sales.round1.entities.payment.results.goods;

import com.hexad.sales.round1.entities.payment.results.goods.goods.BookGood;
import com.hexad.sales.round1.entities.payment.results.goods.goods.NormalGood;
import com.hexad.sales.round1.entities.payment.results.goods.goods.ProductGood;
import com.hexad.sales.round1.enums.GoodType;
import com.hexad.sales.round1.exceptions.GoodsFactoryException;
import com.hexad.sales.round1.services.shipping.CommisionPaymentService;
import com.hexad.sales.round1.services.shipping.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.hexad.sales.round1.exceptions.GoodsFactoryException.*;

@Component
public class GoodsFactory {
  private final ShippingService shippingService;
  private final CommisionPaymentService commisionPaymentService;

  @Autowired
  public GoodsFactory(ShippingService shippingService, CommisionPaymentService commisionPaymentService) {
    this.shippingService = shippingService;
    this.commisionPaymentService = commisionPaymentService;
  }

  public <T extends AbstractGood> T build(GoodType type, String name) {
    AbstractGood toReturn = null;
    switch (type) {
      case NORMAL_BOOD_TYPE:
        toReturn = new NormalGood(type, name);
        break;
      case FISICAL_PRODUCT:
        toReturn = new ProductGood(type, name, shippingService, commisionPaymentService);
        break;
      case BOOK:
        toReturn = new BookGood(type, name, shippingService, commisionPaymentService);
        break;
      default:
        throw new GoodsFactoryException(Cause.CANNOT_FIND_GOOD_TYPE, type);
    }
    return (T) toReturn;
  }

}

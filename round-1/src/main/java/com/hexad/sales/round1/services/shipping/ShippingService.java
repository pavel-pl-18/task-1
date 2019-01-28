package com.hexad.sales.round1.services.shipping;

import com.hexad.sales.round1.entities.payment.results.goods.AbstractGood;
import com.hexad.sales.round1.entities.payment.results.goods.goods.BookGood;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShippingService {
  public <T extends AbstractGood> void generatePackingSlipForShipping(T ... goods) {
    log.info("generate packing slip for shjpping");
  }

  public <T extends AbstractGood> void generateDoublePackingSlipForShipping(T ... goods) {
    log.info("generate double packing slip for shjpping");
  }

}

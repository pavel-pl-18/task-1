package com.hexad.sales.round1.services.shipping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShippingService {
  public void generatePackingSlipForShipping() {
    log.info("generate packing slip for shjpping");
  }

  public void generateDoublePackingSlipForShipping() {
    log.info("generate double packing slip for shjpping");
  }

}

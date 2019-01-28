package com.hexad.sales.round1.exceptions;

import com.hexad.sales.round1.enums.GoodType;

public class GoodsFactoryException extends RuntimeException {

  public enum Cause {
    CANNOT_FIND_GOOD_TYPE
  }

  public GoodsFactoryException(Cause cause) {
    super(cause.name());
  }

  public GoodsFactoryException(Cause cause,
                               GoodType goodType) {
    super(cause.name() + " " + goodType.name());
  }


}

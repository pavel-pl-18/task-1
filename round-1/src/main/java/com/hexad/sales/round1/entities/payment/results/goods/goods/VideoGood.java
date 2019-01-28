package com.hexad.sales.round1.entities.payment.results.goods.goods;                                                           ;

import com.hexad.sales.round1.entities.payment.results.goods.AbstractGood;
import com.hexad.sales.round1.enums.GoodType;
import com.hexad.sales.round1.services.shipping.ShippingService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoGood extends AbstractGood {

  public interface VideoConst {
    String ski = "Learning to Ski";
  }

  private final ShippingService shippingService;
  private boolean addFirstAid = false;
  private final static Pattern pattern = Pattern.compile(VideoConst.ski);


  public VideoGood(GoodType goodType, String name, ShippingService shippingService) {
    super(goodType, name);
    this.shippingService = shippingService;
  }

  @Override
  protected void construct() {
    addFirstAid = checkForFirstAid(this.getName());
  }

  @Override
  protected void runServiceAfterShipping() {
    shippingService.generatePackingSlipForShipping(this);

  }


  public static boolean checkForFirstAid(String name) {
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
  }

}

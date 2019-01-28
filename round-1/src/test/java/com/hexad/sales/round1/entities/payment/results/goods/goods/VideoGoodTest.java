package com.hexad.sales.round1.entities.payment.results.goods.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoGoodTest {
  @Test
  void checkForFirstAid_ok() {
    assertTrue(VideoGood.checkForFirstAid(VideoGood.VideoConst.ski));
  }

  @Test
  void checkForFirstAid_not_ok() {
    assertFalse(VideoGood.checkForFirstAid("sdfsadfdasd"));
  }



}
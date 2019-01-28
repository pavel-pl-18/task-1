package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.master.Firm;
import com.hexad.sales.round1.enums.MembershipStatus;
import com.hexad.sales.round1.utils.DataStubs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessMembershipServiceTest {
  ProcessMembershipService service = new ProcessMembershipService();

  @Test
  void processMembership_ok() {
    // given
    Firm firm = DataStubs.getFirms1();
    firm.setMembershipStatus(null);
    // when
    service.processMembership(firm);
    // then
    assertEquals(firm.getMembershipStatus(), MembershipStatus.ACTIVE);
  }





}
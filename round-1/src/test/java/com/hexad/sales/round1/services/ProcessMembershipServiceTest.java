package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.master.Firm;
import com.hexad.sales.round1.enums.MembershipStatus;
import com.hexad.sales.round1.exceptions.ProcessMembershipException;
import com.hexad.sales.round1.utils.DataStubs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.hexad.sales.round1.exceptions.ProcessMembershipException.*;
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

  @ParameterizedTest
  @MethodSource("processMembership_exceptions_data")
  void processMembership_exceptions(MembershipStatus membershipStatus,
                                    Cause cause) {
    // given
    Firm firm = DataStubs.getFirms1();
    firm.setMembershipStatus(membershipStatus);
    // when then
    Throwable exception = assertThrows(ProcessMembershipException.class, () -> {
      service.processMembership(firm);
    });
    assertEquals(cause.name(), exception.getMessage());
  }

  private static Stream<Arguments> processMembership_exceptions_data() {
    return Stream.of(
        Arguments.of(MembershipStatus.ACTIVE, Cause.CLIENT_IS_ALREADY_MEMBER),
        Arguments.of(MembershipStatus.UPGRATED, Cause.CANNOT_ACTIVATE_MEMBERSHIP_CLIENT_IS_UPGRATED_MEMBER));
  }





}
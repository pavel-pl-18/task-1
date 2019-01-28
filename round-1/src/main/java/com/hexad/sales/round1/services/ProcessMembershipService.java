package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.master.Firm;
import com.hexad.sales.round1.enums.MembershipStatus;
import com.hexad.sales.round1.exceptions.ProcessMembershipException;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterAbortException;

@Service
public class ProcessMembershipService {

  public void processMembership(Firm firm) {
    if (firm.getMembershipStatus() == null || firm.getMembershipStatus() == MembershipStatus.NONE) {
      firm.setMembershipStatus(MembershipStatus.ACTIVE);
    } else {
      switch (firm.getMembershipStatus()) {
        case ACTIVE:
          throw new ProcessMembershipException(
              ProcessMembershipException.Cause.CLIENT_IS_ALREADY_MEMBER);
        case UPGRATED:
          throw new ProcessMembershipException(
              ProcessMembershipException.Cause.CANNOT_ACTIVATE_MEMBERSHIP_CLIENT_IS_UPGRATED_MEMBER);
        default:
          throw new ProcessMembershipException(
              ProcessMembershipException.Cause.UNEXPECTED);
      }
    }


  }

}

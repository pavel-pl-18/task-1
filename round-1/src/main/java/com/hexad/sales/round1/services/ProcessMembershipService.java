package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.master.Firm;
import com.hexad.sales.round1.enums.MembershipStatus;
import com.hexad.sales.round1.exceptions.ProcessMembershipException;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterAbortException;

import static com.hexad.sales.round1.exceptions.ProcessMembershipException.*;

@Service
public class ProcessMembershipService {

  public boolean processMembership(Firm firm) {
    if (firm.getMembershipStatus() == null || firm.getMembershipStatus() == MembershipStatus.NONE) {
      firm.setMembershipStatus(MembershipStatus.ACTIVE);
      return true;
    } else {
      switch (firm.getMembershipStatus()) {
        case ACTIVE:
          throw new ProcessMembershipException(
              Cause.CLIENT_IS_ALREADY_MEMBER);
        case UPGRATED:
          throw new ProcessMembershipException(
              Cause.CANNOT_ACTIVATE_MEMBERSHIP_CLIENT_IS_UPGRATED_MEMBER);
        default:
          throw new ProcessMembershipException(Cause.UNEXPECTED);
      }
    }


  }

  public boolean processUpgrateMembership(Firm firm) {
    if (firm.getMembershipStatus() == null || firm.getMembershipStatus() == MembershipStatus.NONE) {
      throw new ProcessMembershipException(Cause.CANNOT_UPGRATE_MEMBERSHIP_BECAUSE_CLIENT_IS_NOT_A_MEMBER);
    }
    switch (firm.getMembershipStatus()) {
      case ACTIVE:
        firm.setMembershipStatus(MembershipStatus.UPGRATED);
        return true;
      case UPGRATED:
        throw new ProcessMembershipException(Cause.CANNOT_ACTUVATE_UPGRATED_BECAUSE_FIRM_IS_ALREADY_UPGRATED);
      default:
        throw new ProcessMembershipException(Cause.UNEXPECTED);
    }
  }

}

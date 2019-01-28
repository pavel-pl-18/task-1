package com.hexad.sales.round1.exceptions;

public class ProcessMembershipException extends RuntimeException {

  public enum Cause {
    WRONG_PAYMENT_TYPE,
    CLIENT_UNDEFINED,
    CLIENT_IS_ALREADY_MEMBER,
    CLIENT_IS_ALREADY_UPGRATED_MEMBER,
    UNEXPECTED,
    CANNOT_ACTIVATE_MEMBERSHIP_CLIENT_IS_UPGRATED_MEMBER;
  }

  public ProcessMembershipException(Cause cause) {
    super(cause.name());
  }


}

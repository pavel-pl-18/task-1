package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.master.Firm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@Slf4j
public class MailNotificationService {

  public void sendMailMembership(Firm firm) {
    log.info(MessageFormat.format("sending mail to firm {0} name {1}",
        firm.getId(), firm.getName()));
  }

  public void sendMailUpgrateMembership(Firm firm) {
    log.info(MessageFormat.format("sending mail upgrating membership to firm {0} name {1}",
        firm.getId(), firm.getName()));
  }


}

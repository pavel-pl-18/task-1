package com.hexad.sales.round1.entities.master;

import com.hexad.sales.round1.enums.MembershipStatus;
import lombok.Data;

@Data
public class Firm {
    private Long id;
    private String name;
    private MembershipStatus membershipStatus;
    private String email;
}

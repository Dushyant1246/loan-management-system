package com.project.loan_management_system.dto;

import com.project.loan_management_system.entity.enums.KycStatus;
import lombok.*;

import java.time.LocalDate;

/** Minimal fields for creating a Customer. */
public class CustomerCreateRequest {
    public String externalRef;      // optional
    public String fullName;         // required
    public String email;            // optional
    public String phone;            // optional
    public LocalDate dob;           // optional
    public KycStatus kycStatus;     // default PENDING if null
}

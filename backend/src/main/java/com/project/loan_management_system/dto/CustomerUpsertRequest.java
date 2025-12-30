package com.project.loan_management_system.dto;

import com.project.loan_management_system.entity.enums.KycStatus;

import java.time.LocalDate;

/** Upsert payload (used when caller controls externalRef as business key). */
public class CustomerUpsertRequest {
    public String fullName;     // required for create
    public String email;
    public String phone;
    public LocalDate dob;
    public KycStatus kycStatus;
}

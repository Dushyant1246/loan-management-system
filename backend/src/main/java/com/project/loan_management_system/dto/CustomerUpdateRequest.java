package com.project.loan_management_system.dto;

import java.time.LocalDate;

/** Allowed mutable fields for updates (exclude KYC status for dedicated method). */
public class CustomerUpdateRequest {
    public String externalRef;  // optional; must remain unique if set
    public String fullName;     // optional
    public String email;        // optional
    public String phone;        // optional
    public LocalDate dob;       // optional
}

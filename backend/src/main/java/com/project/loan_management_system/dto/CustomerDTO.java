package com.project.loan_management_system.dto;

import com.project.loan_management_system.entity.enums.KycStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
public class CustomerDTO {

    private UUID id;

    private String fullName;

    private String email;

    private String phone;

    private LocalDate dob;

    private KycStatus kycStatus = KycStatus.PENDING;
}

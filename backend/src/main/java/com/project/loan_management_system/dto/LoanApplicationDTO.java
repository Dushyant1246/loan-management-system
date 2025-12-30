package com.project.loan_management_system.dto;

import com.project.loan_management_system.entity.enums.LoanApplicationStatus;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
@Setter
public class LoanApplicationDTO {

    private UUID id;

    private UUID customerId;

    private String customerName;

    private UUID productId;

    private BigDecimal requestedAmount;

    private Integer requestedTenureMonths;

    private BigDecimal proposedRate;

    private LoanApplicationStatus status;

    private String decisionNotes;

    private Instant submittedAt;

    private Instant decidedAt;
}

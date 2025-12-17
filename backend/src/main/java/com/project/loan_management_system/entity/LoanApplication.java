package com.project.loan_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "loan_applications")
public class LoanApplication extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanProduct product;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal requestedAmount;

    @Column(nullable = false)
    private Integer requestedTenureMonths;

    @Column(precision = 9, scale = 6)
    private BigDecimal proposedRate;

    @Column(length = 20, nullable = false)
    private String status = "submitted"; // submitted, under_review, approved, rejected

    @Column(columnDefinition = "TEXT")
    private String decisionNotes;

    @Column(nullable = false, updatable = false)
    private Instant submittedAt = Instant.now();

    private Instant decidedAt;
}

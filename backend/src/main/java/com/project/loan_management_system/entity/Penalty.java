package com.project.loan_management_system.entity;

import com.project.loan_management_system.entity.enums.PenaltyStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "penalties")
public class Penalty extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanAccount loanAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    private RepaymentSchedule schedule;

    @Column(nullable = false)
    private LocalDate appliedOn;

    @Column(length = 50, nullable = false)
    private String type; // late_fee, penalty_interest

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PenaltyStatus status = PenaltyStatus.PENDING;
}

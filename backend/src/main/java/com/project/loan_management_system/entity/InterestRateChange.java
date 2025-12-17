package com.project.loan_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "interest_rate_changes",
       indexes = { @Index(name = "idx_irc_account_effective", columnList = "loanAccount_id,effectiveDate") })
public class InterestRateChange extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanAccount loanAccount;

    @Column(nullable = false)
    private LocalDate effectiveDate;

    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal newNominalAnnualRate;

    @Column(length = 200)
    private String reason;

}

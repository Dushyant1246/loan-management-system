package com.project.loan_management_system.entity;

import com.project.loan_management_system.entity.enums.LedgerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ledger_entries",
       indexes = @Index(name = "idx_ledger_account_date", columnList = "loanAccount_id,entryDate"))
public class LedgerEntry extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanAccount loanAccount;

    @Column(nullable = false)
    private LocalDate entryDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LedgerType type;

    @Column(length = 100, nullable = false)
    private String drAccount;

    @Column(length = 100, nullable = false)
    private String crAccount;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(length = 100)
    private String reference;

    @ManyToOne(fetch = FetchType.LAZY)
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Disbursement disbursement;

}

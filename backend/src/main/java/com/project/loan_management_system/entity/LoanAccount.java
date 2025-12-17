package com.project.loan_management_system.entity;

import com.project.loan_management_system.entity.enums.Compounding;
import com.project.loan_management_system.entity.enums.LoanStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "loan_accounts",
        indexes = { @Index(name = "idx_loan_acc_customer", columnList = "customer_id") })
public class LoanAccount extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanProduct product;

    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String accountNumber;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal principalAmount;

    @Column(nullable = false)
    private Integer tenureMonths;

    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal nominalAnnualRate;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate maturityDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanStatus status = LoanStatus.ACTIVE;

    @Column(length = 3, nullable = false)
    private String currencyCode = "INR";

    @Column(length = 50)
    private String repaymentDayRule = "same_day_each_month";

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Compounding compounding = Compounding.MONTHLY;

    @Column(nullable = false)
    private Boolean variableRate = Boolean.FALSE;

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Disbursement> disbursements = new ArrayList<>();

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InterestRateChange> rateChanges = new ArrayList<>();

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RepaymentSchedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Charge> charges = new ArrayList<>();

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Penalty> penalties = new ArrayList<>();

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LedgerEntry> ledgerEntries = new ArrayList<>();

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Statement> statements = new ArrayList<>();

    @OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

}

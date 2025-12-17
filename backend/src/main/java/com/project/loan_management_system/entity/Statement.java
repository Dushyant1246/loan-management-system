package com.project.loan_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "statements")
public class Statement extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanAccount loanAccount;

    @Column(nullable = false)
    private LocalDate periodStart;

    @Column(nullable = false)
    private LocalDate periodEnd;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal openingBalance;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal closingBalance;

    @Column(length = 300)
    private String url;

}

package com.project.loan_management_system.entity;

import com.project.loan_management_system.entity.enums.ChargeStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "charges")
public class Charge extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanAccount loanAccount;

    @Column(nullable = false)
    private LocalDate chargedOn;

    @Column(length = 50, nullable = false)
    private String type; // processing_fee, insurance, documentation

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChargeStatus status = ChargeStatus.PENDING;

}

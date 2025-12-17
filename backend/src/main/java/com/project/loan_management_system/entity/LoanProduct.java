package com.project.loan_management_system.entity;

import com.project.loan_management_system.entity.enums.DayCountConvention;
import com.project.loan_management_system.entity.enums.InterestMethod;
import com.project.loan_management_system.entity.enums.RepaymentFrequency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "loan_products")
public class LoanProduct extends BaseEntity {

    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String name;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal minAmount;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal maxAmount;

    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal minRate;

    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal maxRate;

    @Column(nullable = false)
    private Integer minTenureMonths;

    @Column(nullable = false)
    private Integer maxTenureMonths;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RepaymentFrequency repaymentFrequency = RepaymentFrequency.MONTHLY;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InterestMethod interestMethod = InterestMethod.REDUCING_BALANCE;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayCountConvention dayCountConvention = DayCountConvention.ACTUAL_365;

    @Column(length = 3, nullable = false)
    private String currencyCode = "INR";

    @Column(nullable = false)
    private Boolean allowPrepayment = Boolean.TRUE;

    @Column(length = 20, nullable = false)
    private String prepaymentRecastMethod = "reduce_tenure"; // or "reduce_emi"

}

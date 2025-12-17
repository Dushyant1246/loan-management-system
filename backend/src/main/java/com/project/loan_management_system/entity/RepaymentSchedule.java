package com.project.loan_management_system.entity;

import com.project.loan_management_system.entity.enums.ScheduleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "repayment_schedules",
       uniqueConstraints = @UniqueConstraint(name = "uq_acc_installment",
                                             columnNames = {"loanAccount_id","installmentNumber"}),
       indexes = @Index(name = "idx_rs_due", columnList = "loanAccount_id,dueDate,status"))
public class RepaymentSchedule extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanAccount loanAccount;

    @Column(nullable = false)
    private Integer installmentNumber;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal emiAmount;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal principalComponent;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal interestComponent;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal feesComponent = BigDecimal.ZERO;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal openingPrincipal;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal closingPrincipal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduleStatus status = ScheduleStatus.DUE;

}

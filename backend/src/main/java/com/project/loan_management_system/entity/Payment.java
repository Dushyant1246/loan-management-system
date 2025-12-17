package com.project.loan_management_system.entity;

import com.project.loan_management_system.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "payments",
       indexes = { @Index(name = "idx_pay_acc_date", columnList = "loanAccount_id,paymentDate"),
                   @Index(name = "idx_pay_idem", columnList = "idempotencyKey", unique = true) })
public class Payment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanAccount loanAccount;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal amountReceived;

    @Column(length = 50)
    private String channel;

    @Column(length = 100)
    private String reference;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status = PaymentStatus.POSTED;

    @Column(length = 120, unique = true)
    private String idempotencyKey;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentAllocation> allocations = new ArrayList<>();

}

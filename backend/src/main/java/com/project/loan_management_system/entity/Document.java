package com.project.loan_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "documents",
       indexes = @Index(name = "idx_docs_account", columnList = "loanAccount_id"))
public class Document extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private LoanAccount loanAccount;

    @Column(length = 50, nullable = false)
    private String type; // agreement, KYC, insurance

    @Column(length = 300, nullable = false)
    private String storageUri;

    @Column(length = 20, nullable = false)
    private String status = "received"; // received, verified

}

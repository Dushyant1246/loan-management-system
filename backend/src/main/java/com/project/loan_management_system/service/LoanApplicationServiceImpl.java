package com.project.loan_management_system.service;

import com.project.loan_management_system.dto.LoanApplicationDTO;
import com.project.loan_management_system.entity.LoanApplication;
import com.project.loan_management_system.repository.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements  LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    private LoanApplicationDTO toLoanApplicationDTO(LoanApplication loanApplication) {
        return LoanApplicationDTO.builder()
                .id(loanApplication.getId())
                .status(loanApplication.getStatus())
                .customerId(loanApplication.getCustomer().getId())
                .decisionNotes(loanApplication.getDecisionNotes())
                .decidedAt(loanApplication.getDecidedAt())
                .proposedRate(loanApplication.getProposedRate())
                .requestedAmount(loanApplication.getRequestedAmount())
                .requestedTenureMonths(loanApplication.getRequestedTenureMonths())
                .submittedAt(loanApplication.getSubmittedAt())
                .productId(loanApplication.getProduct().getId())
                .customerName(loanApplication.getCustomer().getFullName())
                .build();
    }

    @Override
    public Page<LoanApplicationDTO> findAll(Pageable pageable) {
        return loanApplicationRepository.findAll(pageable).map(this :: toLoanApplicationDTO);
    }
}

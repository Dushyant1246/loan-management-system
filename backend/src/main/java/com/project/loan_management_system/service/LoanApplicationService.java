package com.project.loan_management_system.service;

import com.project.loan_management_system.dto.LoanApplicationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoanApplicationService {
    Page<LoanApplicationDTO> findAll(Pageable pageable);
}

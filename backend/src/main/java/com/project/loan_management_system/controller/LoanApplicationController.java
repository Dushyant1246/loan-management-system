package com.project.loan_management_system.controller;


import com.project.loan_management_system.dto.LoanApplicationDTO;
import com.project.loan_management_system.service.LoanApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan/loan-application")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @GetMapping("/page")
    public ResponseEntity<Page<LoanApplicationDTO>> getLoanApplications(Pageable pageable) {
        return ResponseEntity.ok(loanApplicationService.findAll(pageable));
    }

}

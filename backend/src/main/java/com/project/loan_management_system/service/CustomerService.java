package com.project.loan_management_system.service;

import com.project.loan_management_system.dto.CustomerCreateRequest;
import com.project.loan_management_system.dto.CustomerDTO;
import com.project.loan_management_system.dto.CustomerUpdateRequest;
import com.project.loan_management_system.dto.CustomerUpsertRequest;
import com.project.loan_management_system.entity.Customer;
import com.project.loan_management_system.entity.enums.KycStatus;
import com.project.loan_management_system.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * CustomerService defines operations for managing Customer aggregates.
 *
 * Responsibilities:
 * - Create, read, update, delete (CRUD)
 * - KYC lifecycle updates
 * - Search by business keys (externalRef), partial name matches
 * - Pagination support for UI/API
 *
 * Notes:
 * - Implementations should enforce invariants (e.g., unique externalRef).
 * - Consider @Transactional on methods that mutate state.
 */
public interface CustomerService {

    public CustomerDTO findById(UUID id);

    public List<CustomerDTO> findAll();

    public Page<CustomerDTO> findAll(Pageable pageable);
}

package com.project.loan_management_system.service;

import com.project.loan_management_system.dto.CustomerCreateRequest;
import com.project.loan_management_system.dto.CustomerDTO;
import com.project.loan_management_system.dto.CustomerUpdateRequest;
import com.project.loan_management_system.dto.CustomerUpsertRequest;
import com.project.loan_management_system.entity.Customer;
import com.project.loan_management_system.entity.enums.KycStatus;
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

    // === Create ===

    /**
     * Creates a new customer.
     * @param request payload with basic fields (fullName, email, phone, dob, externalRef, kycStatus)
     * @return persisted Customer
     */
    Customer create(CustomerCreateRequest request);

    // === Read ===

    /**
     * Finds a customer by internal UUID.
     */
    CustomerDTO findById(UUID id);

    /**
     * Finds a customer by externalRef (business/integration key).
     */
    Optional<Customer> findByExternalRef(String externalRef);

    /**
     * Lists all customers (use sparingly; prefer pagination).
     */
    List<CustomerDTO> findAll();

    /**
     * Returns a pageable list of customers filtered by name fragment (case-insensitive).
     */
    Page<Customer> searchByName(String namePart, Pageable pageable);

    /**
     * Returns customers filtered by KYC status.
     */
    List<Customer> findByKycStatus(KycStatus status);

    /**
     * Returns customers in a paginated form.
     */
    Page<Customer> findAll(Pageable pageable);

    // === Update ===

    /**
     * Updates mutable fields of a customer.
     * @param id customer UUID
     * @param request allowed fields to update (fullName, email, phone, dob, externalRef)
     * @return updated Customer
     */
    Customer update(UUID id, CustomerUpdateRequest request);

    /**
     * Updates only KYC status (with optional audit note).
     */
    Customer updateKycStatus(UUID id, KycStatus status, String note);

    /**
     * Upserts by externalRef: update if exists, otherwise create.
     */
    Customer upsertByExternalRef(String externalRef, CustomerUpsertRequest request);

    // === Delete ===

    /**
     * Deletes a customer by id.
     * Prefer soft delete in real systems; here we model hard delete.
     */
    void delete(UUID id);

    // === Utility ===

    /**
     * Checks if an externalRef is already taken (excluding an optional id).
     */
    boolean existsExternalRef(String externalRef, UUID excludeId);

    /**
     * Counts total customers (useful for dashboards).
     */
    long count();
}

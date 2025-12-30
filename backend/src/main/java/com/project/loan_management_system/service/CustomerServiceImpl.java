package com.project.loan_management_system.service;

import com.project.loan_management_system.dto.CustomerCreateRequest;
import com.project.loan_management_system.dto.CustomerDTO;
import com.project.loan_management_system.dto.CustomerUpdateRequest;
import com.project.loan_management_system.dto.CustomerUpsertRequest;
import com.project.loan_management_system.entity.Customer;
import com.project.loan_management_system.entity.enums.KycStatus;
import com.project.loan_management_system.exception.ResourceNotFoundException;
import com.project.loan_management_system.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    private CustomerDTO toCustomerDTO(Customer customer){
        return CustomerDTO.builder().fullName(customer.getFullName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .dob(customer.getDob())
                .kycStatus(customer.getKycStatus())
                .id(customer.getId())
                .createdAt(customer.getCreatedAt().atZone(ZoneId.systemDefault()).toLocalDate())
                .build();
    }

    @Override
    public CustomerDTO findById(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
        return toCustomerDTO(customer);
    }
    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(this::toCustomerDTO).toList();
    }
    @Override
    public Page<CustomerDTO> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable).map(this::toCustomerDTO);
    }
}

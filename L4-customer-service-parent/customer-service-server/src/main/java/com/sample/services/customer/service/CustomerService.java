package com.sample.services.customer.service;

import com.sample.services.customer.api.client.model.CustomerRequest;
import com.sample.services.customer.api.client.model.CustomerResponse;
import com.sample.services.customer.converter.api.ApiCustomerConverter;
import com.sample.services.customer.converter.entity.EntityCustomerConverter;
import com.sample.services.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;
import static java.util.Optional.of;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final ApiCustomerConverter customerConverter;
  private final EntityCustomerConverter entityCustomerConverter;

  @Transactional
  public CustomerResponse create(CustomerRequest customerRequest) {
    final CustomerResponse customerResponse = new CustomerResponse();
    // save customer
    of(customerRequest)
        .map(customerConverter::convert)
        .map(customerRepository::save)
        .ifPresent(
            customerEntity -> {
              log.debug("Created customer with email {}", customerRequest.getEmail());
              customerResponse.id(customerEntity.getId());
            });

    return customerResponse;
  }

  @Transactional(readOnly = true)
  public CustomerResponse getCustomer(Long customerId) {
    log.debug("Fetch customer call for customer-Id {}", customerId);
    return customerRepository.findById(customerId)
        .map(entityCustomerConverter::convert)
        .orElseThrow(()-> new RuntimeException(format("Customer with Id %s not found", customerId)));
  }
}

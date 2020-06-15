package com.sample.services.customer.controller;

import com.sample.services.customer.api.client.feign.CustomersApi;
import com.sample.services.customer.api.client.model.CustomerRequest;
import com.sample.services.customer.api.client.model.CustomerResponse;
import com.sample.services.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomersApi {

  private final CustomerService customerService;

  @Override
  public CustomerResponse getCustomer(Long customerId) {
    return customerService.getCustomer(customerId);
  }

  @Override
  public CustomerResponse postCustomer(CustomerRequest customerRequest) {
    return customerService.create(customerRequest);
  }
}

package com.sample.services.customer.converter.entity;

import com.sample.services.customer.api.client.model.CustomerResponse;
import com.sample.services.customer.entity.CustomerEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EntityCustomerConverter implements Converter<CustomerEntity, CustomerResponse> {

  @Override
  public CustomerResponse convert(CustomerEntity source) {
    final CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setId(source.getId());
    customerResponse.setFirstName(source.getFirstName());
    customerResponse.setLastName(source.getLastName());
    customerResponse.setEmail(source.getEmail());
    customerResponse.setPhone(source.getPhone());
    return customerResponse;
  }
}

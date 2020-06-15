package com.sample.services.customer.converter.api;

import com.sample.services.customer.api.client.model.CustomerRequest;
import com.sample.services.customer.entity.CustomerEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApiCustomerConverter implements Converter<CustomerRequest, CustomerEntity> {

  @Override
  public CustomerEntity convert(CustomerRequest source) {
    final CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setFirstName(source.getFirstName());
    customerEntity.setLastName(source.getLastName());
    customerEntity.setEmail(source.getEmail());
    customerEntity.setPhone(source.getPhone());
    return customerEntity;
  }
}

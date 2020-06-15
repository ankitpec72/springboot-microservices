package com.sample.services.customer.entity;

import static com.sample.services.customer.entity.CustomerEntity.TABLE_NAME;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = TABLE_NAME)
public class CustomerEntity {
  public static final String TABLE_NAME = "customer";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String firstName;
  private String lastName;
  private String email;
  private String phone;
}

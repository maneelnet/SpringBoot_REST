package com.example.REST_demo.services;

import com.example.REST_demo.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomer(Integer id);
    String deleteCustomer(Integer id);
    String updateCustomer(Customer updateCustomer, Integer id);

}

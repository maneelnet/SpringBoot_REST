package com.example.REST_demo.services;

import com.example.REST_demo.models.Customer;
import com.example.REST_demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Integer id) {
        return customerRepository.findById(id);
    }

    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "Customer has been deleted";
    }

    public String updateCustomer(Customer updateCustomer, Integer id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(updateCustomer.getName());
                    customer.setEmail(updateCustomer.getEmail());
                    customerRepository.save(customer);
                    return "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return "This customer doesn't exist";
                });
    }

}

package com.example.REST_demo.contollers;

import com.example.REST_demo.models.Customer;
import com.example.REST_demo.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public Customer addNewCustomer(@RequestBody Customer newCustomer) {
        customerService.saveCustomer(newCustomer);
        return newCustomer;
    }

    @GetMapping()
    public List<Customer> viewAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Integer id) {
        return customerService.getCustomer(id);
    }

    @PutMapping("/edit/{id}")
    public String updateCustomer(@RequestBody Customer updateCustomer, @PathVariable Integer id) {
        return customerService.updateCustomer(updateCustomer, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteCustomer(id);
    }


}

package com.example.rpgTest01.service;


import com.example.rpgTest01.model.Customer;
import com.example.rpgTest01.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        repository.save(customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        repository.update(customer);
        return customer;
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
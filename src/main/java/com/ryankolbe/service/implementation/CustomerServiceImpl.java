package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Customer;
import com.ryankolbe.repository.CustomerRepository;
import com.ryankolbe.repository.implementation.CustomerRepositoryImpl;
import com.ryankolbe.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private CustomerServiceImpl() {
        this.customerRepository = CustomerRepositoryImpl.getCustomerRepository();
    }

    @Override
    public Set<Customer> getAll() {
        return this.customerRepository.getAll();
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.create(customer);
    }

    @Override
    public Customer read(String customerId) {
        return this.customerRepository.read(customerId);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.update(customer);
    }

    @Override
    public void delete(String customerId) {
        this.customerRepository.delete(customerId);
    }
}
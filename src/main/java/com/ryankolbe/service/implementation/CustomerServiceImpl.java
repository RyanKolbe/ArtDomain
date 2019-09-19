package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Customer;
import com.ryankolbe.repository.CustomerRepository;
import com.ryankolbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer read(String customerId) {
        Optional<Customer> byId = this.customerRepository.findById(customerId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public void delete(String customerId) {
        this.customerRepository.deleteById(customerId);
    }
}
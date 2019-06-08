package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Customer;
import com.ryankolbe.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("CustomerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {
    private static CustomerRepositoryImpl customerRepository = null;
    private Set<Customer> customers;


    private CustomerRepositoryImpl() {
        this.customers = new HashSet<>();
    }

    public static CustomerRepositoryImpl getCustomerRepository() {
        if (customerRepository == null) customerRepository = new CustomerRepositoryImpl();
        return customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        this.customers.add(customer);
        return customer;
    }

    @Override
    public Customer read(String customerId) {
        return search(customerId);
    }

    @Override
    public Customer update(Customer customer) {
        Customer customerTemp = search(customer.getCustomerId());
        if (customerTemp != null) {
            customers.remove(customerTemp);
            return create(customer);
        }
        return null;
    }

    @Override
    public void delete(String customerId) {
        Customer customerDelete = search(customerId);
        if (customerDelete != null) this.customers.remove(customerDelete);
    }

    private Customer search(final String customerId) {
        for (Customer customerSearch : this.customers) {
            if (customerSearch.getCustomerId().equals(customerId))
                return customerSearch;
        }
        return null;
    }

    @Override
    public Set<Customer> getAll() {
        return this.customers;
    }
}
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Customer;
import com.ryankolbe.factory.CustomerFactory;
import com.ryankolbe.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRepositoryImplTest {
    private static CustomerRepository customerRepository = CustomerRepositoryImpl.getCustomerRepository();
    private static Customer customer;
    private static Set<Customer> customers = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        customer = CustomerFactory.createCustomer("0001", "Joseph", "0846453128");
        customers.add(customerRepository.create(customer));
    }

    @Test
    public void getCustomerRepository() {
        Assert.assertNotNull(customerRepository);
    }

    @Test
    public void create() {
        Customer createCustomer = CustomerFactory.createCustomer("0002", "Joey",
                "0763412498");
        customers.add(customerRepository.create(createCustomer));
        Assert.assertEquals(createCustomer, customerRepository.read(createCustomer.getCustomerId()));
    }

    @Test
    public void read() {
        Customer readCustomer = customerRepository.read(customer.getCustomerId());
        Assert.assertEquals(readCustomer, customerRepository.read(readCustomer.getCustomerId()));
    }

    @Test
    public void update() {
        String newCustomerName = "Paul";
        Customer updateCustomer = new Customer.Builder().copy(customer).customerName(newCustomerName).build();
        customers.add(customerRepository.update(updateCustomer));
        Assert.assertEquals(updateCustomer, customerRepository.read(updateCustomer.getCustomerId()));
    }

    @Test
    public void delete() {
        Customer deleteCustomer = CustomerFactory.createCustomer("0005", "Nigel",
                "067849354");
        customers.add(customerRepository.create(deleteCustomer));
        customers.remove(deleteCustomer);
        customerRepository.delete(deleteCustomer.getCustomerId());
        Assert.assertEquals(customers.size(), customerRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Customer> customerSet = customerRepository.getAll();
        Assert.assertEquals(customerSet, customerRepository.getAll());
    }
}
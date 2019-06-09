package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Customer;
import com.ryankolbe.factory.CustomerFactory;
import com.ryankolbe.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {
    @Autowired
    @Qualifier("CustomerServiceImpl")
    private CustomerService customerService;
    private Customer customer;
    private Set<Customer> customers = new HashSet<>();

    @Before
    public void setUp() {
        customer = customerService.create(CustomerFactory.createCustomer("0001", "Rhea",
                "0854628976"));
        customers.add(customer);
    }

    @Test
    public void create() {
        Customer createCustomer = customerService.create(CustomerFactory.createCustomer("0025",
                "Joseph", "0764985000"));
        customers.add(createCustomer);
        Assert.assertEquals(createCustomer, customerService.read(createCustomer.getCustomerId()));
    }

    @Test
    public void read() {
        Customer readCustomer = customerService.create(CustomerFactory.createCustomer("0065",
                "Luke", "0312754688"));
        customers.add(readCustomer);
        Assert.assertEquals(readCustomer, customerService.read(readCustomer.getCustomerId()));
    }

    @Test
    public void update() {
        String newCustomerName = "Raylene";
        Customer updateCustomer = customerService.update(new Customer.Builder().copy(customer)
                .customerName(newCustomerName).build());
        customers.add(updateCustomer);
        Assert.assertEquals(updateCustomer, customerService.read(updateCustomer.getCustomerId()));
    }

    @Test
    public void delete() {
        customers.addAll(customerService.getAll());
        Customer deleteCustomer = customerService.create(CustomerFactory.createCustomer("9876",
                "Mark", "0684321658"));
        customers.add(deleteCustomer);
        customers.remove(deleteCustomer);
        customerService.delete(deleteCustomer.getCustomerId());
        Assert.assertEquals(customers.size(), customerService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Customer> customerSet = customerService.getAll();
        Assert.assertEquals(customerSet.size(), customerService.getAll().size());
    }
}
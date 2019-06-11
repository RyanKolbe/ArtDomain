package com.ryankolbe.controller;

import com.ryankolbe.domain.Customer;
import com.ryankolbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(@Qualifier("CustomerServiceImpl") CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PostMapping("/update")
    @ResponseBody
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Customer read(@PathVariable String id) {
        return customerService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        customerService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Customer> getAll() {
        return customerService.getAll();
    }
}
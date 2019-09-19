package com.ryankolbe.controller;

import com.ryankolbe.domain.Customer;
import com.ryankolbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    @ResponseBody
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PutMapping("/update")
    @ResponseBody
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Customer read(@PathVariable(required = true) String id) {
        return customerService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        customerService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Customer> getAll() {
        return customerService.getAll();
    }
}
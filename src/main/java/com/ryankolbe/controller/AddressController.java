package com.ryankolbe.controller;

import com.ryankolbe.domain.Address;
import com.ryankolbe.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    @ResponseBody
    public Address create(@RequestBody Address address) {
        return addressService.create(address);
    }

    @PutMapping("/update")
    @ResponseBody
    public Address update(@RequestBody Address address) {
        return addressService.update(address);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable(required = true) String id) {
        return addressService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        addressService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Address> getAll() {
        return addressService.getAll();
    }
}
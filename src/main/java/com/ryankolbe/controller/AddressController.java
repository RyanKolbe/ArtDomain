package com.ryankolbe.controller;

import com.ryankolbe.domain.Address;
import com.ryankolbe.service.AddressService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(@Qualifier("AddressServiceImp") AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Address create(Address address) {
        return addressService.create(address);
    }

    @PostMapping("/update")
    @ResponseBody
    public Address update(Address address) {
        return addressService.update(address);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable String id) {
        return addressService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        addressService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Address> getAll() {
        return addressService.getAll();
    }
}
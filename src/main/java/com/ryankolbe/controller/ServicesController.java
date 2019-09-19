package com.ryankolbe.controller;

import com.ryankolbe.domain.Services;
import com.ryankolbe.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @PostMapping("/create")
    @ResponseBody
    public Services create(@RequestBody Services services) {
        return servicesService.create(services);
    }

    @PutMapping("/update")
    @ResponseBody
    public Services update(@RequestBody Services services) {
        return servicesService.update(services);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Services read(@PathVariable(required = true) String id) {
        return servicesService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        servicesService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Services> getAll() {
        return servicesService.getAll();
    }
}
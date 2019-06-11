package com.ryankolbe.controller;

import com.ryankolbe.domain.Services;
import com.ryankolbe.service.ServicesService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/services")
public class ServicesController {
    private final ServicesService servicesService;

    public ServicesController(@Qualifier("ServicesServiceImpl") ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Services create(@RequestBody Services services) {
        return servicesService.create(services);
    }

    @PostMapping("/update")
    @ResponseBody
    public Services update(@RequestBody Services services) {
        return servicesService.update(services);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Services read(@PathVariable String id) {
        return servicesService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        servicesService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Services> getAll() {
        return servicesService.getAll();
    }
}
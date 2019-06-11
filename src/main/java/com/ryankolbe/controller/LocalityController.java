package com.ryankolbe.controller;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.service.LocalityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/locality")
public class LocalityController {
    private final LocalityService localityService;

    public LocalityController(@Qualifier("LocalityServiceImpl") LocalityService localityService) {
        this.localityService = localityService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Locality create(@RequestBody Locality locality) {
        return localityService.create(locality);
    }

    @PostMapping("/update")
    @ResponseBody
    public Locality update(@RequestBody Locality locality) {
        return localityService.update(locality);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Locality read(@PathVariable String id) {
        return localityService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        localityService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Locality> getAll() {
        return localityService.getAll();
    }
}
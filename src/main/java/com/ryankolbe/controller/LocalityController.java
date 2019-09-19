package com.ryankolbe.controller;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locality")
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @PostMapping("/create")
    @ResponseBody
    public Locality create(@RequestBody Locality locality) {
        return localityService.create(locality);
    }

    @PutMapping("/update")
    @ResponseBody
    public Locality update(@RequestBody Locality locality) {
        return localityService.update(locality);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Locality read(@PathVariable String id) {
        return localityService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        localityService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Locality> getAll() {
        return localityService.getAll();
    }
}
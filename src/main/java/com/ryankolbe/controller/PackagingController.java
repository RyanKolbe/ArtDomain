package com.ryankolbe.controller;

import com.ryankolbe.domain.Packaging;
import com.ryankolbe.service.PackagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packaging")
public class PackagingController {

    @Autowired
    private PackagingService packagingService;

    @PostMapping("/create")
    @ResponseBody
    public Packaging create(@RequestBody Packaging packaging) {
        return packagingService.create(packaging);
    }

    @PutMapping("/update")
    @ResponseBody
    public Packaging update(@RequestBody Packaging packaging) {
        return packagingService.update(packaging);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Packaging read(@PathVariable(required = true) String id) {
        return packagingService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        packagingService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Packaging> getAll() {
        return packagingService.getAll();
    }
}
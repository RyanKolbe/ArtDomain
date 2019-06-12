package com.ryankolbe.controller;

import com.ryankolbe.domain.Packaging;
import com.ryankolbe.service.PackagingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/packaging")
public class PackagingController {
    private final PackagingService packagingService;

    public PackagingController(@Qualifier("PackagingServiceImpl") PackagingService packagingService) {
        this.packagingService = packagingService;
    }

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
    public Packaging read(@PathVariable String id) {
        return packagingService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        packagingService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Packaging> getAll() {
        return packagingService.getAll();
    }
}
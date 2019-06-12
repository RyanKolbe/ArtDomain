package com.ryankolbe.controller;

import com.ryankolbe.domain.ArtStock;
import com.ryankolbe.service.ArtStockService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/artStock")
public class ArtStockController {
    private final ArtStockService artStockService;

    public ArtStockController(@Qualifier("ArtStockServiceImpl") ArtStockService artStockService) {
        this.artStockService = artStockService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ArtStock create(@RequestBody ArtStock artStock) {
        return artStockService.create(artStock);
    }

    @PutMapping("/update")
    @ResponseBody
    public ArtStock update(@RequestBody ArtStock artStock) {
        return artStockService.update(artStock);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ArtStock read(@PathVariable String id) {
        return artStockService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        artStockService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<ArtStock> getAll() {
        return artStockService.getAll();
    }
}
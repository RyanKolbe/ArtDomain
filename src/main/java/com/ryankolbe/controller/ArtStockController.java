package com.ryankolbe.controller;

import com.ryankolbe.domain.ArtStock;
import com.ryankolbe.service.ArtStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artStock")
public class ArtStockController {

    @Autowired
    private ArtStockService artStockService;

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
    public ArtStock read(@PathVariable(required = true) String id) {
        return artStockService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        artStockService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<ArtStock> getAll() {
        return artStockService.getAll();
    }
}
package com.ryankolbe.controller;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.service.PaintingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/painting")
public class PaintingController {
    private final PaintingService paintingService;

    public PaintingController(@Qualifier("PaintingServiceImpl") PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Painting create(@RequestBody Painting painting) {
        return paintingService.create(painting);
    }

    @PutMapping("/update")
    @ResponseBody
    public Painting update(@RequestBody Painting painting) {
        return paintingService.update(painting);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Painting read(@PathVariable String id) {
        return paintingService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        paintingService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Painting> getAll() {
        return paintingService.getAll();
    }
}
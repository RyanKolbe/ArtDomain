package com.ryankolbe.controller;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/painting")
public class PaintingController {

    @Autowired
    private PaintingService paintingService;

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
    public Painting read(@PathVariable(required = true) String id) {
        return paintingService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        paintingService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Painting> getAll() {
        return paintingService.getAll();
    }
}
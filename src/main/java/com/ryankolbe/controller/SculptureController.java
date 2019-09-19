package com.ryankolbe.controller;

import com.ryankolbe.domain.Sculpture;
import com.ryankolbe.service.SculptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sculpture")
public class SculptureController {

    @Autowired
    private SculptureService sculptureService;

    @PostMapping("/create")
    @ResponseBody
    public Sculpture create(@RequestBody Sculpture sculpture) {
        return sculptureService.create(sculpture);
    }

    @PutMapping("/update")
    @ResponseBody
    public Sculpture update(@RequestBody Sculpture sculpture) {
        return sculptureService.update(sculpture);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Sculpture read(@PathVariable String id) {
        return sculptureService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        sculptureService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Sculpture> getAll() {
        return sculptureService.getAll();
    }
}
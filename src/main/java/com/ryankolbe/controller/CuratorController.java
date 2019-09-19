package com.ryankolbe.controller;

import com.ryankolbe.domain.Curator;
import com.ryankolbe.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curator")
public class CuratorController {

    @Autowired
    private CuratorService curatorService;

    @PostMapping("/create")
    @ResponseBody
    public Curator create(@RequestBody Curator curator) {
        return curatorService.create(curator);
    }

    @PutMapping("/update")
    @ResponseBody
    public Curator update(@RequestBody Curator curator) {
        return curatorService.update(curator);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Curator read(@PathVariable String id) {
        return curatorService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        curatorService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Curator> getAll() {
        return curatorService.getAll();
    }
}
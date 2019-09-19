package com.ryankolbe.controller;

import com.ryankolbe.domain.Returns;
import com.ryankolbe.service.ReturnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returns")
public class ReturnsController {

    @Autowired
    private ReturnsService returnsService;

    @PostMapping("/create")
    @ResponseBody
    public Returns create(@RequestBody Returns returns) {
        return returnsService.create(returns);
    }

    @PutMapping("/update")
    @ResponseBody
    public Returns update(@RequestBody Returns returns) {
        return returnsService.update(returns);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Returns read(@PathVariable String id) {
        return returnsService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        returnsService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Returns> getAll() {
        return returnsService.getAll();
    }
}
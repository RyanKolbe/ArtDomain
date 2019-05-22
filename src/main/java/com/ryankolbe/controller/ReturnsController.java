package com.ryankolbe.controller;

import com.ryankolbe.domain.Returns;
import com.ryankolbe.service.ReturnsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/returns")
public class ReturnsController {
    private final ReturnsService returnsService;

    public ReturnsController(@Qualifier("ReturnsServiceImpl") ReturnsService returnsService) {
        this.returnsService = returnsService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Returns create(Returns returns) {
        return returnsService.create(returns);
    }

    @PostMapping("/update")
    @ResponseBody
    public Returns update(Returns returns) {
        return returnsService.update(returns);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Returns read(@PathVariable String id) {
        return returnsService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        returnsService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Returns> getAll() {
        return returnsService.getAll();
    }
}
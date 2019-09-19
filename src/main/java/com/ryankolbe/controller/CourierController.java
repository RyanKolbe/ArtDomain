package com.ryankolbe.controller;

import com.ryankolbe.domain.Courier;
import com.ryankolbe.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @PostMapping("/create")
    @ResponseBody
    public Courier create(@RequestBody Courier courier) {
        return courierService.create(courier);
    }

    @PutMapping("/update")
    @ResponseBody
    public Courier update(@RequestBody Courier courier) {
        return courierService.update(courier);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Courier read(@PathVariable String id) {
        return courierService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        courierService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Courier> getAll() {
        return courierService.getAll();
    }
}
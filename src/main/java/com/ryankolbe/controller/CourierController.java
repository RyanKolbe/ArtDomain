package com.ryankolbe.controller;

import com.ryankolbe.domain.Courier;
import com.ryankolbe.service.CourierService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/courier")
public class CourierController {
    private final CourierService courierService;

    public CourierController(@Qualifier("CourierServiceImpl") CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Courier create(Courier courier) {
        return courierService.create(courier);
    }

    @PostMapping("/update")
    @ResponseBody
    public Courier update(Courier courier) {
        return courierService.update(courier);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Courier read(@PathVariable String id) {
        return courierService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        courierService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Courier> getAll() {
        return courierService.getAll();
    }
}
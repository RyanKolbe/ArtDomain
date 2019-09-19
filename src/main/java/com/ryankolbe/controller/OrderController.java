package com.ryankolbe.controller;

import com.ryankolbe.domain.Order;
import com.ryankolbe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    @ResponseBody
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping("/update")
    @ResponseBody
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Order read(@PathVariable(required = true) String id) {
        return orderService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        orderService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Order> getAll() {
        return orderService.getAll();
    }
}
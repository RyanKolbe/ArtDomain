package com.ryankolbe.controller;

import com.ryankolbe.domain.Order;
import com.ryankolbe.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(@Qualifier("OrderServiceImpl") OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Order create(Order order) {
        return orderService.create(order);
    }

    @PostMapping("/update")
    @ResponseBody
    public Order update(Order order) {
        return orderService.update(order);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Order read(@PathVariable String id) {
        return orderService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        orderService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Order> getAll() {
        return orderService.getAll();
    }
}
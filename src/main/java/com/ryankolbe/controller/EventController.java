package com.ryankolbe.controller;

import com.ryankolbe.domain.Event;
import com.ryankolbe.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    @ResponseBody
    public Event create(@RequestBody Event event) {
        return eventService.create(event);
    }

    @PutMapping("/update")
    @ResponseBody
    public Event update(@RequestBody Event event) {
        return eventService.update(event);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Event read(@PathVariable String id) {
        return eventService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        eventService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Event> getAll() {
        return eventService.getAll();
    }
}
package com.ryankolbe.controller;

import com.ryankolbe.domain.Gallery;
import com.ryankolbe.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @PostMapping("/create")
    @ResponseBody
    public Gallery create(@RequestBody Gallery gallery) {
        return galleryService.create(gallery);
    }

    @PutMapping("/update")
    @ResponseBody
    public Gallery update(@RequestBody Gallery gallery) {
        return galleryService.update(gallery);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Gallery read(@PathVariable(required = true) String id) {
        return galleryService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        galleryService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Gallery> getAll() {
        return galleryService.getAll();
    }
}
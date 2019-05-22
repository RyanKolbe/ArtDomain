package com.ryankolbe.controller;

import com.ryankolbe.domain.Gallery;
import com.ryankolbe.service.GalleryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/gallery")
public class GalleryController {
    private final GalleryService galleryService;

    public GalleryController(@Qualifier("GalleryServiceImpl") GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Gallery create(Gallery gallery) {
        return galleryService.create(gallery);
    }

    @PostMapping("/update")
    @ResponseBody
    public Gallery update(Gallery gallery) {
        return galleryService.update(gallery);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Gallery read(@PathVariable String id) {
        return galleryService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        galleryService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Gallery> getAll() {
        return galleryService.getAll();
    }
}
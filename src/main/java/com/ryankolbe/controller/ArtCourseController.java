package com.ryankolbe.controller;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.service.ArtCourseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/artCourse")
public class ArtCourseController {
    private final ArtCourseService artCourseService;

    public ArtCourseController(@Qualifier("ArtCourseServiceImpl") ArtCourseService artCourseService) {
        this.artCourseService = artCourseService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ArtCourse create(@RequestBody ArtCourse artCourse) {
        return artCourseService.create(artCourse);
    }

    @PostMapping("/update")
    @ResponseBody
    public ArtCourse update(@RequestBody ArtCourse artCourse) {
        return artCourseService.update(artCourse);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ArtCourse read(@PathVariable String id) {
        return artCourseService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        artCourseService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<ArtCourse> getAll() {
        return artCourseService.getAll();
    }
}
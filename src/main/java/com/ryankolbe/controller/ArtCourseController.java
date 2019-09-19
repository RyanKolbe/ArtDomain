package com.ryankolbe.controller;

import com.ryankolbe.domain.ArtCourse;
import com.ryankolbe.service.ArtCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artCourse")
public class ArtCourseController {

    @Autowired
    private ArtCourseService artCourseService;

    @PostMapping("/create")
    @ResponseBody
    public ArtCourse create(@RequestBody ArtCourse artCourse) {
        return artCourseService.create(artCourse);
    }

    @PutMapping("/update")
    @ResponseBody
    public ArtCourse update(@RequestBody ArtCourse artCourse) {
        return artCourseService.update(artCourse);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ArtCourse read(@PathVariable(required = true) String id) {
        return artCourseService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        artCourseService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<ArtCourse> getAll() {
        return artCourseService.getAll();
    }
}
package com.ryankolbe.controller;

import com.ryankolbe.domain.Artist;
import com.ryankolbe.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/create")
    @ResponseBody
    public Artist create(@RequestBody Artist artist) {
        return artistService.create(artist);
    }

    @PutMapping("/update")
    @ResponseBody
    public Artist update(@RequestBody Artist artist) {
        return artistService.update(artist);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Artist read(@PathVariable String id) {
        return artistService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        artistService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Artist> getAll() {
        return artistService.getAll();
    }
}
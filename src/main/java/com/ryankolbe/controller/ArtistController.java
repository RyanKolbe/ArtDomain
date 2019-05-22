package com.ryankolbe.controller;

import com.ryankolbe.domain.Artist;
import com.ryankolbe.service.ArtistService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(@Qualifier("ArtistServiceImpl") ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Artist create(Artist artist) {
        return artistService.create(artist);
    }

    @PostMapping("/update")
    @ResponseBody
    public Artist update(Artist artist) {
        return artistService.update(artist);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Artist read(@PathVariable String id) {
        return artistService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        artistService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Artist> getAll() {
        return artistService.getAll();
    }
}
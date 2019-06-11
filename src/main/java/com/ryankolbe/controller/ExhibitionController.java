package com.ryankolbe.controller;

import com.ryankolbe.domain.Exhibition;
import com.ryankolbe.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {
    private final ExhibitionService exhibitionService;

    public ExhibitionController(@Qualifier("ExhibitionServiceImpl") ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Exhibition create(@RequestBody Exhibition exhibition) {
        return exhibitionService.create(exhibition);
    }

    @PostMapping("/update")
    @ResponseBody
    public Exhibition update(@RequestBody Exhibition exhibition) {
        return exhibitionService.update(exhibition);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Exhibition read(@PathVariable String id) {
        return exhibitionService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        exhibitionService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Exhibition> getAll() {
        return exhibitionService.getAll();
    }
}
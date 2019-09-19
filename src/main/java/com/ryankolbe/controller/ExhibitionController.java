package com.ryankolbe.controller;

import com.ryankolbe.domain.Exhibition;
import com.ryankolbe.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {

    @Autowired
    private ExhibitionService exhibitionService;

    @PostMapping("/create")
    @ResponseBody
    public Exhibition create(@RequestBody Exhibition exhibition) {
        return exhibitionService.create(exhibition);
    }

    @PutMapping("/update")
    @ResponseBody
    public Exhibition update(@RequestBody Exhibition exhibition) {
        return exhibitionService.update(exhibition);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Exhibition read(@PathVariable String id) {
        return exhibitionService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        exhibitionService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Exhibition> getAll() {
        return exhibitionService.getAll();
    }
}
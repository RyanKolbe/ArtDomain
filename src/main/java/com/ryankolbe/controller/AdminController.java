package com.ryankolbe.controller;

import com.ryankolbe.domain.Admin;
import com.ryankolbe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    @ResponseBody
    public Admin create(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    @PutMapping("/update")
    @ResponseBody
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Admin read(@PathVariable String id) {
        return adminService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        adminService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Admin> getAll() {
        return adminService.getAll();
    }
}
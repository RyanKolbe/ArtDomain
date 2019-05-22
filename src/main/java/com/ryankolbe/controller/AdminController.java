package com.ryankolbe.controller;

import com.ryankolbe.domain.Admin;
import com.ryankolbe.service.AdminService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(@Qualifier("AdminServiceImpl") AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Admin create(Admin admin) {
        return adminService.create(admin);
    }

    @PostMapping("/update")
    @ResponseBody
    public Admin update(Admin admin) {
        return adminService.update(admin);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Admin read(@PathVariable String id) {
        return adminService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        adminService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Admin> getAll() {
        return adminService.getAll();
    }
}
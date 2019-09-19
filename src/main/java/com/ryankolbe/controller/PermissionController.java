package com.ryankolbe.controller;

import com.ryankolbe.domain.Permission;
import com.ryankolbe.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/create")
    @ResponseBody
    public Permission create(@RequestBody Permission permission) {
        return permissionService.create(permission);
    }

    @PutMapping("/update")
    @ResponseBody
    public Permission update(@RequestBody Permission permission) {
        return permissionService.update(permission);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Permission read(@PathVariable String id) {
        return permissionService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        permissionService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<Permission> getAll() {
        return permissionService.getAll();
    }
}
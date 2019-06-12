package com.ryankolbe.controller;

import com.ryankolbe.domain.Permission;
import com.ryankolbe.service.PermissionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    private final PermissionService permissionService;

    public PermissionController(@Qualifier("PermissionServiceImpl") PermissionService permissionService) {
        this.permissionService = permissionService;
    }

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
    public Set<Permission> getAll() {
        return permissionService.getAll();
    }
}
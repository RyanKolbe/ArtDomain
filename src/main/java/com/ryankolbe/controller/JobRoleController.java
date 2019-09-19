package com.ryankolbe.controller;

import com.ryankolbe.domain.JobRole;
import com.ryankolbe.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobRole")
public class JobRoleController {

    @Autowired
    private JobRoleService jobRoleService;

    @PostMapping("/create")
    @ResponseBody
    public JobRole create(@RequestBody JobRole jobRole) {
        return jobRoleService.create(jobRole);
    }

    @PutMapping("/update")
    @ResponseBody
    public JobRole update(@RequestBody JobRole jobRole) {
        return jobRoleService.update(jobRole);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public JobRole read(@PathVariable(required = true) String id) {
        return jobRoleService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable(required = true) String id) {
        jobRoleService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public List<JobRole> getAll() {
        return jobRoleService.getAll();
    }
}
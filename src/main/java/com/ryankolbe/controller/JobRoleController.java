package com.ryankolbe.controller;

import com.ryankolbe.domain.JobRole;
import com.ryankolbe.service.JobRoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/jobRole")
public class JobRoleController {
    private final JobRoleService jobRoleService;

    public JobRoleController(@Qualifier("JobRoleServiceImpl") JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @PostMapping("/create")
    @ResponseBody
    public JobRole create(JobRole jobRole) {
        return jobRoleService.create(jobRole);
    }

    @PostMapping("/update")
    @ResponseBody
    public JobRole update(JobRole jobRole) {
        return jobRoleService.update(jobRole);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public JobRole read(@PathVariable String id) {
        return jobRoleService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        jobRoleService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<JobRole> getAll() {
        return jobRoleService.getAll();
    }
}
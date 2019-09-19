package com.ryankolbe.service;

import com.ryankolbe.domain.JobRole;

import java.util.List;

public interface JobRoleService extends IService<JobRole, String> {
    List<JobRole> getAll();
}
package com.ryankolbe.service;

import com.ryankolbe.domain.JobRole;

import java.util.Set;

public interface JobRoleService extends IService<JobRole, String> {
    Set<JobRole> getAll();
}
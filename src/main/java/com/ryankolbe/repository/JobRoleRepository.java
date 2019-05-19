package com.ryankolbe.repository;

import com.ryankolbe.domain.JobRole;

import java.util.Set;

public interface JobRoleRepository extends IRepository<JobRole, String> {
    Set<JobRole> getAll();
}
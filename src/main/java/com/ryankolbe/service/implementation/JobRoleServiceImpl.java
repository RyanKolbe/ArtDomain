package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.JobRole;
import com.ryankolbe.repository.JobRoleRepository;
import com.ryankolbe.repository.implementation.JobRoleRepositoryImpl;
import com.ryankolbe.service.JobRoleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("JobRoleServiceImpl")
public class JobRoleServiceImpl implements JobRoleService {
    private final JobRoleRepository jobRoleRepository;

    private JobRoleServiceImpl() {
        this.jobRoleRepository = JobRoleRepositoryImpl.getJobRoleRepository();
    }

    @Override
    public JobRole create(JobRole jobRole) {
        return this.jobRoleRepository.create(jobRole);
    }

    @Override
    public JobRole read(String jobRoleId) {
        return this.jobRoleRepository.read(jobRoleId);
    }

    @Override
    public JobRole update(JobRole jobRole) {
        return this.jobRoleRepository.update(jobRole);
    }

    @Override
    public void delete(String jobRoleId) {
        this.jobRoleRepository.delete(jobRoleId);
    }

    @Override
    public Set<JobRole> getAll() {
        return this.jobRoleRepository.getAll();
    }
}
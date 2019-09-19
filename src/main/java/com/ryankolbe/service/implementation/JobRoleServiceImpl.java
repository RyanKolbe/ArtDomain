package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.JobRole;
import com.ryankolbe.repository.JobRoleRepository;
import com.ryankolbe.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("JobRoleServiceImpl")
public class JobRoleServiceImpl implements JobRoleService {
    @Autowired
    private JobRoleRepository jobRoleRepository;

    @Override
    public JobRole create(JobRole jobRole) {
        return this.jobRoleRepository.save(jobRole);
    }

    @Override
    public JobRole read(String jobRoleId) {
        Optional<JobRole> byId = this.jobRoleRepository.findById(jobRoleId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public JobRole update(JobRole jobRole) {
        return this.jobRoleRepository.save(jobRole);
    }

    @Override
    public void delete(String jobRoleId) {
        this.jobRoleRepository.deleteById(jobRoleId);
    }

    @Override
    public List<JobRole> getAll() {
        return this.jobRoleRepository.findAll();
    }
}
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.JobRole;
import com.ryankolbe.repository.JobRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("JobRoleRepository")
public class JobRoleRepositoryImpl implements JobRoleRepository {
    private static JobRoleRepositoryImpl jobRoleRepository = null;
    private Set<JobRole> jobRoles;


    private JobRoleRepositoryImpl() {
        this.jobRoles = new HashSet<>();
    }

    public static JobRoleRepositoryImpl getJobRoleRepository() {
        if (jobRoleRepository == null) jobRoleRepository = new JobRoleRepositoryImpl();
        return jobRoleRepository;
    }

    @Override
    public JobRole create(JobRole jobRole) {
        this.jobRoles.add(jobRole);
        return jobRole;
    }

    @Override
    public JobRole read(String jobRoleId) {
        return search(jobRoleId);
    }

    @Override
    public JobRole update(JobRole jobRole) {
        JobRole jobRoleTemp = search(jobRole.getJobRoleId());
        if (jobRoleTemp != null) {
            return create(new JobRole.Builder()
                    .copy(jobRoleTemp)
                    .build());
        }
        return null;
    }

    @Override
    public void delete(String jobRoleId) {
        JobRole jobRoleDelete = search(jobRoleId);
        if (jobRoleDelete != null) this.jobRoles.remove(jobRoleDelete);
    }

    private JobRole search(final String jobRoleId) {
        for (JobRole jobRoleSearch : this.jobRoles) {
            if (jobRoleSearch.getJobRoleId().equals(jobRoleId))
                return jobRoleSearch;
        }
        return null;
    }

    @Override
    public Set<JobRole> getAll() {
        return this.jobRoles;
    }
}
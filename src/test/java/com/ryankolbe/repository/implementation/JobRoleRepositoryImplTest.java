package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.JobRole;
import com.ryankolbe.factory.JobRoleFactory;
import com.ryankolbe.repository.JobRoleRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JobRoleRepositoryImplTest {
    private static JobRoleRepository jobRoleRepository = JobRoleRepositoryImpl.getJobRoleRepository();
    private static JobRole jobRole;
    private static Set<JobRole> jobRoles = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        jobRole = JobRoleFactory.createJobRole("0001", "Admin Clerk", 4500.00);
        jobRoles.add(jobRoleRepository.create(jobRole));
    }

    @Test
    public void getJobRoleRepository() {
        Assert.assertNotNull(jobRoleRepository);
    }

    @Test
    public void create() {
        JobRole createJobRole = JobRoleFactory.createJobRole("0020", "Admin Supervisor",
                8000.00);
        jobRoles.add(jobRoleRepository.create(createJobRole));
    }

    @Test
    public void read() {
        JobRole readJobRole = jobRoleRepository.read(jobRole.getJobRoleId());
        Assert.assertEquals(readJobRole, jobRoleRepository.read(readJobRole.getJobRoleId()));
    }

    @Test
    public void update() {
        String newJobRoleDescription = "Admin Manager";
        double newJobRoleSalary = 10000.00;
        JobRole updateJobRole = new JobRole.Builder().copy(jobRole).jobRoleDescription(newJobRoleDescription).
                jobRoleSalary(newJobRoleSalary).build();
        jobRoles.add(jobRoleRepository.update(updateJobRole));
        Assert.assertEquals(updateJobRole, jobRoleRepository.read(updateJobRole.getJobRoleId()));
    }

    @Test
    public void delete() {
        JobRole deleteJobRole = JobRoleFactory.createJobRole("0009", "Logistics Controller",
                11500.00);
        jobRoles.add(jobRoleRepository.create(deleteJobRole));
        jobRoles.remove(deleteJobRole);
        jobRoleRepository.delete(deleteJobRole.getJobRoleId());
        Assert.assertEquals(jobRoles.size(), jobRoleRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<JobRole> jobRoleSet = jobRoleRepository.getAll();
        Assert.assertEquals(jobRoleSet, jobRoleRepository.getAll());
    }
}
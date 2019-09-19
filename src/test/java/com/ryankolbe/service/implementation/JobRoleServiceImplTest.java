package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.JobRole;
import com.ryankolbe.factory.JobRoleFactory;
import com.ryankolbe.service.JobRoleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JobRoleServiceImplTest {
    @Autowired
    @Qualifier("JobRoleServiceImpl")
    private JobRoleService jobRoleService;
    private JobRole jobRole;
    private Set<JobRole> jobRoles = new HashSet<>();

    @Before
    public void setUp() {
        jobRole = jobRoleService.create(JobRoleFactory.createJobRole("0001", "Admin Clerk",
                4500.00));
        jobRoles.add(jobRole);
    }

    @Test
    public void create() {
        JobRole createJobRole = jobRoleService.create(JobRoleFactory.createJobRole("0002",
                "Admin Supervisor", 8000.00));
        jobRoles.add(createJobRole);
        Assert.assertEquals(createJobRole, jobRoleService.read(createJobRole.getJobRoleId()));
    }

    @Test
    public void read() {
        JobRole readJobRole = jobRoleService.read(jobRole.getJobRoleId());
        Assert.assertEquals(readJobRole, jobRoleService.read(readJobRole.getJobRoleId()));
    }

    @Test
    public void update() {
        String newJobRoleDescription = "Admin Manager";
        JobRole updateJobRole = jobRoleService.update(new JobRole.Builder().copy(jobRole)
                .jobRoleDescription(newJobRoleDescription).build());
        jobRoles.add(updateJobRole);
        Assert.assertEquals(updateJobRole, jobRoleService.read(updateJobRole.getJobRoleId()));
    }

    @Test
    public void delete() {
        jobRoles.addAll(jobRoleService.getAll());
        JobRole deleteJobRole = jobRoleService.create(JobRoleFactory.createJobRole("0026",
                "Logistics Controller", 8500.00));
        jobRoles.add(deleteJobRole);
        jobRoles.remove(deleteJobRole);
        jobRoleService.delete(deleteJobRole.getJobRoleId());
        Assert.assertEquals(jobRoles.size(), jobRoleService.getAll().size());
    }

    @Test
    public void getAll() {
        List<JobRole> jobRoleSet = jobRoleService.getAll();
        Assert.assertEquals(jobRoleSet.size(), jobRoleService.getAll().size());
    }
}
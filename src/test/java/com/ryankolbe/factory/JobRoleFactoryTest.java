package com.ryankolbe.factory;

import com.ryankolbe.domain.JobRole;
import org.junit.Assert;
import org.junit.Test;

public class JobRoleFactoryTest {

    @Test
    public void createJobRole() {
        JobRole jobRole = JobRoleFactory.createJobRole("0001", "Runner", 2000.00);
        Assert.assertEquals("Runner", jobRole.getJobRoleDescription());
    }
}
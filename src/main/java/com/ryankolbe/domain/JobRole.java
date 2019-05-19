package com.ryankolbe.domain;

import java.util.Objects;

public class JobRole implements Comparable<JobRole> {
    private String jobRoleId;
    private String jobRoleDescription;
    private double jobRoleSalary;

    private JobRole() {
    }

    private JobRole(Builder builder) {
        this.jobRoleId = builder.jobRoleId;
        this.jobRoleDescription = builder.jobRoleDescription;
        this.jobRoleSalary = builder.jobRoleSalary;
    }

    public String getJobRoleId() {
        return jobRoleId;
    }

    public String getJobRoleDescription() {
        return jobRoleDescription;
    }

    public double getJobRoleSalary() {
        return jobRoleSalary;
    }

    @Override
    public String toString() {
        return "JobRole{" +
                "jobRoleId='" + jobRoleId + '\'' +
                ", jobRoleDescription='" + jobRoleDescription + '\'' +
                ", jobRoleSalary=" + jobRoleSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobRole)) return false;
        JobRole jobRole = (JobRole) o;
        return getJobRoleId().equals(jobRole.getJobRoleId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJobRoleId());
    }

    @Override
    public int compareTo(JobRole jobRole) {
        return this.jobRoleId.compareToIgnoreCase(jobRole.jobRoleId);
    }

    public static class Builder {
        private String jobRoleId;
        private String jobRoleDescription;
        private double jobRoleSalary;

        public Builder jobRoleId(String jobRoleId) {
            this.jobRoleId = jobRoleId;
            return this;
        }

        public Builder jobRoleDescription(String jobRoleDescription) {
            this.jobRoleDescription = jobRoleDescription;
            return this;
        }

        public Builder jobRoleSalary(double jobRoleSalary) {
            this.jobRoleSalary = jobRoleSalary;
            return this;
        }

        public Builder copy(JobRole jobRole) {
            this.jobRoleId = jobRole.jobRoleId;
            this.jobRoleDescription = jobRole.jobRoleDescription;
            this.jobRoleSalary = jobRole.jobRoleSalary;
            return this;
        }

        public JobRole build() {
            return new JobRole(this);
        }
    }
}
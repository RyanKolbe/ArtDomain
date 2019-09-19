package com.ryankolbe.repository;

import com.ryankolbe.domain.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRoleRepository extends JpaRepository<JobRole, String> {
}
package com.ryankolbe.repository;

import com.ryankolbe.domain.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, String> {
}
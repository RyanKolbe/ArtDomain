package com.ryankolbe.repository;

import com.ryankolbe.domain.Packaging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackagingRepository extends JpaRepository<Packaging, String> {
}
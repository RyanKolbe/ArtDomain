package com.ryankolbe.repository;

import com.ryankolbe.domain.Returns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnsRepository extends JpaRepository<Returns, String> {
}
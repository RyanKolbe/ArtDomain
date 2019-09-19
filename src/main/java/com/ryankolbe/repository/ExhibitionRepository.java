package com.ryankolbe.repository;

import com.ryankolbe.domain.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, String> {
}
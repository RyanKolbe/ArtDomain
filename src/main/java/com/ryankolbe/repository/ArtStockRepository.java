package com.ryankolbe.repository;

import com.ryankolbe.domain.ArtStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtStockRepository extends JpaRepository<ArtStock, String> {
}